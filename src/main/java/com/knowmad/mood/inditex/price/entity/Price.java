package com.knowmad.mood.inditex.price.entity;

import com.knowmad.mood.inditex.price.entity.converter.CurrencyConverter;
import com.knowmad.mood.inditex.price.entity.enums.Currency;
import jakarta.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by dani on 11/26/24
 */
@Entity(name = "PRICES")
public class Price {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "BRAND_ID")
    private Long brandId;

    @Column(name = "START_DATE")

    private LocalDateTime startDate;
    @Column(name = "END_DATE")

    private LocalDateTime endDate;

    @Column(name = "PRICE_LIST")
    private Long priceList;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRIORITY")
    private Long priority;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "CURR")
    @Convert(converter = CurrencyConverter.class)
    private Currency currency;

    private Price() {}

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Long getPriceList() {
        return priceList;
    }

    public Long getPriority() {
        return priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
