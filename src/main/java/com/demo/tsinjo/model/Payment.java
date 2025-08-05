package com.demo.tsinjo.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Payment {
  private Long id;
  private String reference;
  private PaymentMethod method;
  private Integer amountAr;
  private LocalDateTime date;
  private String status;
}
