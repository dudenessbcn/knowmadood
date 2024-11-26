package com.knowmad.mood.inditex.price.entity.converter;

import com.knowmad.mood.inditex.price.entity.enums.Currency;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.AttributeConverter;

/**
 * Created by dani on 11/26/24
 */

public class CurrencyConverter implements AttributeConverter<Currency, String> {

    @Override
    public String convertToDatabaseColumn(Currency currency) {
        if (currency == null) {
            return null;
        }
        return currency.name();
    }

    @Override
    public Currency convertToEntityAttribute(String currency) {
        if (StringUtils.isEmpty(currency)) {
            return null;
        }
        return Currency.valueOf(currency);
    }
}
