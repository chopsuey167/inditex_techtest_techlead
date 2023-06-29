package com.inditex.ecommerce.controller;

import com.inditex.ecommerce.model.Price;
import com.inditex.ecommerce.service.PriceService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/prices")
public class PriceController {

  private final PriceService priceService;

  @GetMapping
  public @ResponseBody ResponseEntity<?> getPriceByFilters(@RequestBody PriceFilterRequest priceFilterRequest) {

    List<Price> listPrice = priceService.findPricesByFilters(priceFilterRequest);
    return new ResponseEntity<>(listPrice, HttpStatus.OK);
  }

}
