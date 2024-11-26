package com.knowmad.mood.inditex.price.mapper;

import com.knowmad.mood.inditex.price.dto.PriceFilter;
import com.knowmad.mood.inditex.price.dto.PriceResponse;
import com.knowmad.mood.inditex.price.entity.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by dani on 11/26/24
 */
@Component
@Mapper(componentModel = "spring")
public interface PriceMapper {

    @Mapping(target = "applicablePriceList", source = "priceList")
    PriceResponse toDTO(Price price);

    @Mapping(target = "applicableDate", source = "date")
    @Mapping(target = "productId", source = "product")
    @Mapping(target = "brandId", source = "brand")
    PriceFilter toFilter(LocalDateTime date, Long product, Long brand);
}
