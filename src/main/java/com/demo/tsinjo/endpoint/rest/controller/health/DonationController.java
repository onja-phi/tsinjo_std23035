package com.demo.tsinjo.endpoint.rest.controller.health;

import com.demo.tsinjo.model.Donation;
import com.demo.tsinjo.repository.DonationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donations")
public class DonationController {

    private final DonationRepository donationRepository;

    public DonationController(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @GetMapping
    public List<Donation> getAllDonations() {
        return donationRepository.findAllOrderByPaymentDateDesc();
    }
}

