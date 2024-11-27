package com.knowmad.mood.inditex.price.service;

import com.knowmad.mood.inditex.price.dto.PriceFilter;
import com.knowmad.mood.inditex.price.dto.PriceResponse;
import com.knowmad.mood.inditex.price.entity.Price;
import com.knowmad.mood.inditex.price.entity.PriceBuilder;
import com.knowmad.mood.inditex.price.entity.enums.Currency;
import com.knowmad.mood.inditex.price.mapper.PriceMapper;
import com.knowmad.mood.inditex.price.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceImplTest {

    public static final String DATE = "2020-06-16T21:00:00";
    public static final String END_DATE = "2020-12-31T23:59:59";
    public static final long BRAND_ID = 1L;
    public static final long PRODUCT_ID = 35455L;
    public static final double PRICE = 50.00;

    @Mock
    private PriceMapper mapper;

    @Mock
    private PriceRepository repository;

    @InjectMocks
    private PriceServiceImpl sut;

    @Test
    void get_prices_is_OK() {
        var date = LocalDateTime.parse(DATE);

        var filter = getFilter();

        var entity = List.of(buildEntity());
        var response = buildResponse();
        when(mapper.toFilter(date, PRODUCT_ID, BRAND_ID)).thenReturn(filter);
        when(repository.findByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(
                filter.getApplicableDate(), filter.getApplicableDate(),
                filter.getProductId(), filter.getBrandId())).thenReturn(entity);
        when(mapper.toDTO(entity.get(0))).thenReturn(response);

        var actual = sut.getPrices(date, PRODUCT_ID, BRAND_ID);

        assertEquals(PRODUCT_ID, actual.getProductId());
        assertEquals(BRAND_ID, actual.getBrandId());
        assertEquals(PRICE, actual.getPrice().doubleValue());
        assertEquals(1, actual.getApplicablePriceList());
        assertEquals(LocalDateTime.parse(DATE), actual.getStartDate());
        assertEquals(LocalDateTime.parse(END_DATE), actual.getEndDate());
    }

    private static PriceFilter getFilter() {
        var filter = new PriceFilter();
        filter.setApplicableDate(LocalDateTime.parse(DATE));
        filter.setBrandId(BRAND_ID);
        filter.setProductId(PRODUCT_ID);
        return filter;
    }

    private static Price buildEntity() {
        return PriceBuilder.builder()
                .id(1L)
                .brandId(BRAND_ID)
                .productId(PRODUCT_ID)
                .priceList(1L)
                .priority(1L)
                .currency(Currency.EUR)
                .startDate(LocalDateTime.parse(DATE))
                .endDate(LocalDateTime.parse(END_DATE))
                .price(BigDecimal.valueOf(PRICE))
                .build();
    }

    private static PriceResponse buildResponse() {
        var response = new PriceResponse();
        response.setProductId(PRODUCT_ID);
        response.setBrandId(BRAND_ID);
        response.setApplicablePriceList(1);
        response.setStartDate(LocalDateTime.parse(DATE));
        response.setEndDate(LocalDateTime.parse(END_DATE));
        response.setPrice(BigDecimal.valueOf(PRICE));
        return response;
    }
}