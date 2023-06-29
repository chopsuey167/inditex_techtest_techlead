package com.inditex.ecommerce.controller;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PriceFilterRequest {

  private String applicationDate;
  private Long productId;
  private Long brandId;
}
