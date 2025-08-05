package com.demo.tsinjo.repository;

import com.demo.tsinjo.model.Help;
import com.demo.tsinjo.model.Beneficiary;
import com.demo.tsinjo.model.Payment;
import com.demo.tsinjo.model.PaymentMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HelpRepository {

    private final JdbcTemplate jdbcTemplate;

    public HelpRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Help> findAllOrderByPaymentDateDesc() {
        String sql = "SELECT h.id as help_id, " +
                "beneficiary.id as beneficiary_id, beneficiary.full_name as beneficiary_name, beneficiary.email as beneficiary_email, " +
                "payment.id as payment_id, payment.reference, payment.method, payment.amount_ar, payment.date, payment.status, h.description " +
                "FROM help h " +
                "JOIN beneficiary ON h.beneficiary_id = beneficiary.id " +
                "JOIN payment ON h.payment_id = payment.id " +
                "ORDER BY payment.date DESC";

        return jdbcTemplate.query(sql, new HelpRowMapper());
    }

    private static class HelpRowMapper implements RowMapper<Help> {
        @Override
        public Help mapRow(ResultSet rs, int rowNum) throws SQLException {
            Help help = new Help();

            // Beneficiary
            Beneficiary beneficiary = new Beneficiary();
            beneficiary.setFullName(rs.getString("beneficiary_name"));
            beneficiary.setEmail(rs.getString("beneficiary_email"));
            help.setBeneficiary(beneficiary);

            // Payment
            Payment payment = new Payment();
            payment.setId(rs.getLong("payment_id"));
            payment.setReference(rs.getString("reference"));
            payment.setMethod(PaymentMethod.valueOf(rs.getString("method")));
            payment.setAmountAr(rs.getInt("amount_ar"));
            payment.setDate(rs.getTimestamp("date").toLocalDateTime());
            payment.setStatus(rs.getString("status"));
            help.setPayment(payment);

            // Description
            help.setDescription(rs.getString("description"));

            return help;
        }
    }
}
