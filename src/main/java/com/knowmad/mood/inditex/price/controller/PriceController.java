package com.knowmad.mood.inditex.price.controller;

import com.knowmad.mood.inditex.price.dto.PriceFilter;
import com.knowmad.mood.inditex.price.dto.PriceResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dani on 11/26/24
 */

@RestController
@RequestMapping("inditex/v1")
public class PriceController {

    @GetMapping("prices")
    public PriceResponse getPrices(@RequestParam PriceFilter filter) {
        return null;
    }
}
