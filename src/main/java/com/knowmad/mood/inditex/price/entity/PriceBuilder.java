package com.knowmad.mood.inditex.price.entity;

import com.knowmad.mood.inditex.price.entity.enums.Currency;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by dani on 11/27/24
 */

public class PriceBuilder {

    protected Long id;
    protected Long brandId;
    protected LocalDateTime startDate;
    protected LocalDateTime endDate;
    protected Long priceList;
    protected Long productId;
    protected Long priority;
    protected BigDecimal price;
    protected Currency currency;

    public static PriceBuilder builder() {
        return new PriceBuilder();
    }

    public PriceBuilder id(Long id) {
        this.id = id;
        return this;
    }
    public PriceBuilder brandId(Long brandId) {
        this.brandId = brandId;
        return this;
    }

    public PriceBuilder startDate(LocalDateTime date) {
        this.startDate = date;
        return this;
    }

    public PriceBuilder endDate(LocalDateTime date) {
        this.endDate = date;
        return this;
    }

    public PriceBuilder priceList(Long priceList) {
        this.priceList = priceList;
        return this;
    }

    public PriceBuilder productId(Long productId) {
        this.productId = productId;
        return this;
    }

    public PriceBuilder priority(Long priority) {
        this.priority = priority;
        return this;
    }

    public PriceBuilder price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public PriceBuilder currency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public Price build() {
        return new Price(this);
    }


}
