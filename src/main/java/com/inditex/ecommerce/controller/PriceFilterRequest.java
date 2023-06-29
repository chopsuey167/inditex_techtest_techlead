package com.inditex.ecommerce.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode
public class PriceFilterRequest {

  private String applicationDate;
  private Long productId;
  private Long brandId;
}
