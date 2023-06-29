package com.inditex.ecommerce.service;

import com.inditex.ecommerce.controller.PriceFilterRequest;
import com.inditex.ecommerce.model.Price;
import com.inditex.ecommerce.repository.PriceRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PriceService {

  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  private final PriceRepository priceRepository;

  public List<Price> findPricesByFilters(PriceFilterRequest priceFilterRequest) {
    return priceRepository.findPriceByFilter(
        priceFilterRequest.getBrandId(),
        priceFilterRequest.getProductId(),
        LocalDateTime.parse(priceFilterRequest.getApplicationDate(), formatter));
  }

}
