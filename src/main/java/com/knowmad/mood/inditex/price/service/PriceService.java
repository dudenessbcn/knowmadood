package com.knowmad.mood.inditex.price.service;

import com.knowmad.mood.inditex.price.dto.PriceFilter;
import com.knowmad.mood.inditex.price.dto.PriceResponse;

/**
 * Created by dani on 11/26/24
 */
public interface PriceService {

    PriceResponse getPrices(PriceFilter filter);
}
