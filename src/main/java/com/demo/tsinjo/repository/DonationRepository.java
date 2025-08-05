package com.demo.tsinjo.repository;

import com.demo.tsinjo.model.Donation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DonationRepository {

    private final JdbcTemplate jdbcTemplate;

    public DonationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Donation> findAllOrderByPaymentDateDesc() {
        String sql = "SELECT d.id as donation_id, " +
                "donor.id as donor_id, donor.full_name as donor_name, donor.email as donor_email, " +
                "payment.id as payment_id, payment.reference, payment.method, payment.amount_ar, payment.date, payment.status " +
                "FROM donation d " +
                "JOIN donor ON d.donor_id = donor.id " +
                "JOIN payment ON d.payment_id = payment.id " +
                "ORDER BY payment.date DESC";

        return jdbcTemplate.query(sql, new DonationRowMapper());
    }
}
