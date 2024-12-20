package com.knowmad.mood.inditex.price.service;

import com.knowmad.mood.inditex.price.dto.PriceResponse;
import com.knowmad.mood.inditex.price.mapper.PriceMapper;
import com.knowmad.mood.inditex.price.repository.PriceRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;

/**
 * Created by dani on 11/26/24
 */

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;
    private final PriceMapper mapper;

    public PriceServiceImpl(PriceRepository priceRepository,
                            PriceMapper mapper) {
        this.priceRepository = priceRepository;
        this.mapper = mapper;
    }

    @Override
    public PriceResponse getPrices(LocalDateTime date,
                                   Long product,
                                   Long brand) {
        var filter = mapper.toFilter(date, product, brand);

        var entity =
                priceRepository.findByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(filter.getApplicableDate(),
                        filter.getApplicableDate(),
                        filter.getProductId(),
                        filter.getBrandId());
        if (!CollectionUtils.isEmpty(entity)) {
            return entity.stream().findFirst().map(mapper::toDTO).orElse(null);
        }
        return new PriceResponse();
    }
}
