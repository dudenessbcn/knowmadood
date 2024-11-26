package com.knowmad.mood.inditex.price.service;

import com.knowmad.mood.inditex.configuration.exception.PriceNotFoundException;
import com.knowmad.mood.inditex.price.dto.PriceFilter;
import com.knowmad.mood.inditex.price.dto.PriceResponse;

import java.time.LocalDateTime;

/**
 * Created by dani on 11/26/24
 */
public interface PriceService {

    PriceResponse getPrices(LocalDateTime date, Long productId, Long brandId);
}
