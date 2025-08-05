package com.demo.tsinjo.model;

import lombok.Data;

@Data
public class Donation {
  private Long id;
  private Donor donor;
  private Payment payment;
}
