package com.demo.tsinjo.repository;

import com.demo.tsinjo.model.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DonationRowMapper implements RowMapper<Donation> {

    @Override
    public Donation mapRow(ResultSet rs, int rowNum) throws SQLException {
        Donor donor = new Donor();
        donor.setId(rs.getLong("donor_id"));
        donor.setFullName(rs.getString("donor_name"));
        donor.setEmail(rs.getString("donor_email"));

        Payment payment = new Payment();
        payment.setId(rs.getLong("payment_id"));
        payment.setReference(rs.getString("reference"));
        payment.setMethod(rs.getString("method"));
        payment.setAmountAr(rs.getInt("amount_ar"));
        payment.setDate(rs.getDate("date").toLocalDate());
        payment.setStatus(rs.getString("status"));

        Donation donation = new Donation();
        donation.setId(rs.getLong("donation_id"));
        donation.setDonor(donor);
        donation.setPayment(payment);

        return donation;
    }
}
