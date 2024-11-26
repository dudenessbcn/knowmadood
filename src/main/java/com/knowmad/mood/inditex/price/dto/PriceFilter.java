package com.knowmad.mood.inditex.price.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by dani on 11/26/24
 */

public class PriceFilter implements Serializable {

    @Serial
    private static final long serialVersionUID = 1212234343445L;

    private LocalDateTime applicableDate;
    private Long productId;
    private Long brandId;

    public LocalDateTime getApplicableDate() {
        return applicableDate;
    }

    public void setApplicableDate(LocalDateTime applicableDate) {
        this.applicableDate = applicableDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
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
