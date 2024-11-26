package com.knowmad.mood.inditex.price.controller;

import com.knowmad.mood.inditex.configuration.ApiURL;
import com.knowmad.mood.inditex.price.dto.PriceResponse;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.UriComponentsBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceControllerTest {

    private static final String PROTOCOL_SERVER = "http://localhost:";
    private static final String SEPARATOR = "/";
    private static final String PRICES_URL = "/prices";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void isOK() throws URISyntaxException {
        String baseUrl = PROTOCOL_SERVER +
                "8080" +
                ApiURL.BASE_PATH +
                ApiURL.VERSION +
                PRICES_URL;

        URI uri = new URI(baseUrl);

//        var variables = new HashMap<String, Object>();
//        variables.put("date", LocalDateTime.parse("2020-06-14T00:00:01"));
//        variables.put("product", 35455);
//        variables.put("brand", 1);
        var date = LocalDateTime.parse("2020-06-14T00:00:01");
        long product = 35455;
        long brand = 1;
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

//        String urlTemplate = UriComponentsBuilder.fromHttpUrl(baseUrl)
//                .queryParam("date", "{date}")
//                .queryParam("product", "{product}")
//                .queryParam("brand", "{brand}")
//                .encode()
//                .toUriString();
//
//        Map<String, ?> params = new HashMap<>();
//        params.put("date", date);
//        params.put("product", product);
//        params.put("brand", brand);

       var response =  restTemplate.exchange(baseUrl + "?date={date}&product={product}&brand={brand}",
                HttpMethod.GET,
                entity,
                PriceResponse.class,
                date,
                product,
                brand
        );
        Assertions.assertNotNull(response);

    }

}