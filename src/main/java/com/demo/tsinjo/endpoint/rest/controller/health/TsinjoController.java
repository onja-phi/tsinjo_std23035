package com.demo.tsinjo.endpoint.rest.controller.health;

import com.demo.tsinjo.model.Donation;
import com.demo.tsinjo.model.Help;
import com.demo.tsinjo.repository.DonationRepository;

import com.demo.tsinjo.repository.HelpRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TsinjoController {

  private final DonationRepository donationRepo;
  private final HelpRepository helpRepo;

  public TsinjoController(DonationRepository donationRepo, HelpRepository helpRepo) {
    this.donationRepo = donationRepo;
    this.helpRepo = helpRepo;
  }

  @GetMapping("/history")
  public Map<String, List<?>> getHistory() {
    List<Donation> donations = donationRepo.findAllOrderByPaymentDateDesc();
    List<Help> helps = helpRepo.findAllOrderByPaymentDateDesc();

    Map<String, List<?>> result = new HashMap<>();
    result.put("donations", donations);
    result.put("helps", helps);
    return result;
  }
}
