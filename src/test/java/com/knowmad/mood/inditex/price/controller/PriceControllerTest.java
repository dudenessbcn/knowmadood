package com.knowmad.mood.inditex.price.controller;

import com.knowmad.mood.inditex.InditexApplication;
import com.knowmad.mood.inditex.configuration.ApiURL;
import com.knowmad.mood.inditex.price.dto.PriceResponse;
import org.springframework.http.HttpMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = InditexApplication.class)
class PriceControllerTest {

    private static final String PROTOCOL_SERVER = "http://localhost:";
    private static final String PRICES_URL = "/prices";
    public static final int PRODUCT = 35455;
    public static final int BRAND = 1;


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void day_14_10_am_product_35455_brand_zara() {
        String baseUrl = buildBaseUrl();

        var date = LocalDateTime.parse("2020-06-14T10:00:00");
        HttpEntity<?> entity = buildHttpEntity();

        var response =  restTemplate.exchange(baseUrl + "?date={date}&product={product}&brand={brand}",
                HttpMethod.GET,
                entity,
                PriceResponse.class,
                date,
                PRODUCT,
                BRAND
        );
        Assertions.assertEquals(1, response.getBody().getBrandId());
        Assertions.assertEquals(1, response.getBody().getApplicablePriceList());
        Assertions.assertEquals(35455, response.getBody().getProductId());
        Assertions.assertEquals(35.50, response.getBody().getPrice().doubleValue());
        Assertions.assertEquals(LocalDateTime.parse("2020-06-14T00:00:00"), response.getBody().getStartDate());
        Assertions.assertEquals(LocalDateTime.parse("2020-12-31T23:59:59"), response.getBody().getEndDate());

    }

    @Test
    void day_14_16_pm_product_35455_brand_zara() {
        String baseUrl = buildBaseUrl();

        var date = LocalDateTime.parse("2020-06-14T16:00:00");
        HttpEntity<?> entity = buildHttpEntity();

        var response =  restTemplate.exchange(baseUrl + "?date={date}&product={product}&brand={brand}",
                HttpMethod.GET,
                entity,
                PriceResponse.class,
                date,
                PRODUCT,
                BRAND
        );
        Assertions.assertEquals(1, response.getBody().getBrandId());
        Assertions.assertEquals(2, response.getBody().getApplicablePriceList());
        Assertions.assertEquals(35455, response.getBody().getProductId());
        Assertions.assertEquals(25.45, response.getBody().getPrice().doubleValue());
        Assertions.assertEquals(LocalDateTime.parse("2020-06-14T15:00:00"), response.getBody().getStartDate());
        Assertions.assertEquals(LocalDateTime.parse("2020-06-14T18:30:00"), response.getBody().getEndDate());

    }

    @Test
    void day_14_21_pm_product_35455_brand_zara() {
        String baseUrl = buildBaseUrl();

        var date = LocalDateTime.parse("2020-06-14T21:00:00");
        HttpEntity<?> entity = buildHttpEntity();

        var response =  restTemplate.exchange(baseUrl + "?date={date}&product={product}&brand={brand}",
                HttpMethod.GET,
                entity,
                PriceResponse.class,
                date,
                PRODUCT,
                BRAND
        );
        Assertions.assertEquals(1, response.getBody().getBrandId());
        Assertions.assertEquals(1, response.getBody().getApplicablePriceList());
        Assertions.assertEquals(35455, response.getBody().getProductId());
        Assertions.assertEquals(35.50, response.getBody().getPrice().doubleValue());
        Assertions.assertEquals(LocalDateTime.parse("2020-06-14T00:00:00"), response.getBody().getStartDate());
        Assertions.assertEquals(LocalDateTime.parse("2020-12-31T23:59:59"), response.getBody().getEndDate());
    }

    @Test
    void day_15_10_am_product_35455_brand_zara() {
        String baseUrl = buildBaseUrl();

        var date = LocalDateTime.parse("2020-06-15T10:00:00");
        HttpEntity<?> entity = buildHttpEntity();

        var response =  restTemplate.exchange(baseUrl + "?date={date}&product={product}&brand={brand}",
                HttpMethod.GET,
                entity,
                PriceResponse.class,
                date,
                PRODUCT,
                BRAND
        );
        Assertions.assertEquals(1, response.getBody().getBrandId());
        Assertions.assertEquals(3, response.getBody().getApplicablePriceList());
        Assertions.assertEquals(35455, response.getBody().getProductId());
        Assertions.assertEquals(30.50, response.getBody().getPrice().doubleValue());
        Assertions.assertEquals(LocalDateTime.parse("2020-06-15T00:00:00"), response.getBody().getStartDate());
        Assertions.assertEquals(LocalDateTime.parse("2020-06-15T11:00:00"), response.getBody().getEndDate());
    }

    @Test
    void day_16_21_pm_product_35455_brand_zara() {
        String baseUrl = buildBaseUrl();

        var date = LocalDateTime.parse("2020-06-16T21:00:00");
        HttpEntity<?> entity = buildHttpEntity();

        var response =  restTemplate.exchange(baseUrl + "?date={date}&product={product}&brand={brand}",
                HttpMethod.GET,
                entity,
                PriceResponse.class,
                date,
                PRODUCT,
                BRAND
        );
        Assertions.assertEquals(1, response.getBody().getBrandId());
        Assertions.assertEquals(4, response.getBody().getApplicablePriceList());
        Assertions.assertEquals(35455, response.getBody().getProductId());
        Assertions.assertEquals(38.95, response.getBody().getPrice().doubleValue());
        Assertions.assertEquals(LocalDateTime.parse("2020-06-15T16:00:00"), response.getBody().getStartDate());
        Assertions.assertEquals(LocalDateTime.parse("2020-12-31T23:59:59"), response.getBody().getEndDate());
    }

    private static HttpEntity<?> buildHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }

    private static String buildBaseUrl() {
        return PROTOCOL_SERVER +
                "8080" +
                ApiURL.BASE_PATH +
                ApiURL.VERSION +
                PRICES_URL;
    }

}