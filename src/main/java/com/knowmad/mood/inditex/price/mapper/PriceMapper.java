package com.knowmad.mood.inditex.price.mapper;

import com.knowmad.mood.inditex.price.dto.PriceResponse;
import com.knowmad.mood.inditex.price.entity.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created by dani on 11/26/24
 */
@Mapper(componentModel = "spring")
public interface PriceMapper {

    @Mapping(target = "applicablePriceList", source = "priceList")
    PriceResponse toDTO(Price price);
}
