package com.knowmad.mood.inditex.price.controller;

import com.knowmad.mood.inditex.configuration.ApiURL;
import com.knowmad.mood.inditex.price.dto.PriceFilter;
import com.knowmad.mood.inditex.price.dto.PriceResponse;
import com.knowmad.mood.inditex.price.service.PriceService;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * Created by dani on 11/26/24
 */

@RestController
@RequestMapping(ApiURL.BASE_PATH + ApiURL.VERSION)
public class PriceController {

    private final PriceService service;

    public PriceController(PriceService service) {
        this.service = service;
    }
    @GetMapping("/prices")
    public ResponseEntity<PriceResponse> getPrices(@RequestParam("date")
                                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @NotNull LocalDateTime date,
                                                   @RequestParam @NotNull Long product,
                                                   @RequestParam @NotNull Long brand) {
        var response = service.getPrices(date, product, brand);
        return new ResponseEntity<PriceResponse>(response, HttpStatus.ACCEPTED);
    }
//
//    @GetMapping("/prices")
//    public ResponseEntity<PriceResponse> getPrices() {
//        return new ResponseEntity<PriceResponse>((PriceResponse) null, HttpStatus.ACCEPTED);
//    }
}
