package com.inditex.ecommerce.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.ecommerce.model.Price;
import com.inditex.ecommerce.service.PriceService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

  private static ObjectMapper mapper = new ObjectMapper();
  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  @MockBean
  private PriceService priceService;
  @Autowired
  private MockMvc mvc;

  @Test
  void itShouldGetPricesByFilter_Case1() throws Exception {

    // Given
    PriceFilterRequest priceFilterRequest = new PriceFilterRequest("2020-06-14 10:00:00", 35455L, 1L);
    List<Price> listPrice = new ArrayList<>();
    listPrice.add(
        new Price(1L,
            1L,
            LocalDateTime.parse("2020-06-14 00:00:00", formatter),
            LocalDateTime.parse("2020-12-31 23:59:59", formatter),
            1L,
            35455,
            0,
            35.50,
            "EUR")
    );

    when(priceService.findPricesByFilters(priceFilterRequest)).thenReturn(listPrice);

    //When

    ResultActions response = mvc.perform(get("/api/v1/prices")
        .content(mapper.writeValueAsString(priceFilterRequest))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
    );

    //Then

    response.andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.size()").value(listPrice.size()))
        .andExpect(content().json(mapper.writeValueAsString(listPrice)));

  }

  @Test
  void itShouldGetPricesByFilter_Case2() throws Exception {

    // Given
    PriceFilterRequest priceFilterRequest = new PriceFilterRequest("2020-06-14 16:00:00", 35455L, 1L);
    List<Price> listPrice = new ArrayList<>();
    listPrice.add(
        new Price(1L,
            1L,
            LocalDateTime.parse("2020-06-14 00:00:00", formatter),
            LocalDateTime.parse("2020-12-31 23:59:59", formatter),
            1L, 35455, 0, 35.50, "EUR")
    );
    listPrice.add(
        new Price(2L,
            1L,
            LocalDateTime.parse("2020-06-14 15:00:00", formatter),
            LocalDateTime.parse("2020-06-14 18:30:00", formatter),
            2L, 35455, 0, 25.45, "EUR")
    );

    when(priceService.findPricesByFilters(priceFilterRequest)).thenReturn(listPrice);

    //When

    ResultActions response = mvc.perform(get("/api/v1/prices")
        .content(mapper.writeValueAsString(priceFilterRequest))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
    );

    //Then

    response.andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.size()").value(listPrice.size()))
        .andExpect(content().json(mapper.writeValueAsString(listPrice)));

  }

  @Test
  void itShouldGetPricesByFilter_Case3() throws Exception {

    // Given
    PriceFilterRequest priceFilterRequest = new PriceFilterRequest("2020-06-14 21:00:00", 35455L, 1L);
    List<Price> listPrice = new ArrayList<>();
    listPrice.add(
        new Price(1L,
            1L,
            LocalDateTime.parse("2020-06-14 00:00:00", formatter),
            LocalDateTime.parse("2020-12-31 23:59:59", formatter),
            1L, 35455, 0, 35.50, "EUR")
    );

    when(priceService.findPricesByFilters(priceFilterRequest)).thenReturn(listPrice);

    //When

    ResultActions response = mvc.perform(get("/api/v1/prices")
        .content(mapper.writeValueAsString(priceFilterRequest))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
    );

    //Then

    response.andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.size()").value(listPrice.size()))
        .andExpect(content().json(mapper.writeValueAsString(listPrice)));

  }

  @Test
  void itShouldGetPricesByFilter_Case4() throws Exception {

    // Given
    PriceFilterRequest priceFilterRequest = new PriceFilterRequest("2020-06-15 10:00:00", 35455L, 1L);
    List<Price> listPrice = new ArrayList<>();
    listPrice.add(
        new Price(1L,
            1L,
            LocalDateTime.parse("2020-06-14 00:00:00", formatter),
            LocalDateTime.parse("2020-12-31 23:59:59", formatter),
            1L, 35455, 0, 35.50, "EUR")
    );
    listPrice.add(
        new Price(3L,
            1L,
            LocalDateTime.parse("2020-06-15 00:00:00", formatter),
            LocalDateTime.parse("2020-06-15 11:00:00", formatter),
            3L, 35455, 1, 30.5, "EUR")
    );
    when(priceService.findPricesByFilters(priceFilterRequest)).thenReturn(listPrice);

    //When

    ResultActions response = mvc.perform(get("/api/v1/prices")
        .content(mapper.writeValueAsString(priceFilterRequest))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
    );

    //Then

    response.andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.size()").value(listPrice.size()))
        .andExpect(content().json(mapper.writeValueAsString(listPrice)));

  }

  @Test
  void itShouldGetPricesByFilter_Case5() throws Exception {

    // Given
    PriceFilterRequest priceFilterRequest = new PriceFilterRequest("2020-06-16 21:00:00", 35455L, 1L);
    List<Price> listPrice = new ArrayList<>();
    listPrice.add(
        new Price(1L,
            1L,
            LocalDateTime.parse("2020-06-14 00:00:00", formatter),
            LocalDateTime.parse("2020-12-31 23:59:59", formatter),
            1L, 35455, 0, 35.50, "EUR")
    );
    listPrice.add(
        new Price(4L,
            1L,
            LocalDateTime.parse("2020-06-15 16:00:00", formatter),
            LocalDateTime.parse("2020-12-31 23:59:59", formatter),
            4L, 35455, 1, 38.95, "EUR")
    );

    when(priceService.findPricesByFilters(priceFilterRequest)).thenReturn(listPrice);

    //When

    ResultActions response = mvc.perform(get("/api/v1/prices")
        .content(mapper.writeValueAsString(priceFilterRequest))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
    );

    //Then

    response.andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.size()").value(listPrice.size()))
        .andExpect(content().json(mapper.writeValueAsString(listPrice)));

  }

}