package com.demo.tsinjo.model;

import lombok.Data;

@Data
public class Help {
  private Long id;
  private Beneficiary beneficiary;
  private Payment payment;
  private String description;
}
