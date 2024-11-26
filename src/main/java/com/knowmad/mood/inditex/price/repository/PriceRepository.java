package com.knowmad.mood.inditex.price.repository;

import com.knowmad.mood.inditex.price.entity.Price;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by dani on 11/26/24
 */
public interface PriceRepository extends CrudRepository<Price, Long> {

    List<Price> findByProductIdAndBrandId(Long productId,
                                          Long brandId);

    List<Price> findByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(LocalDateTime start, LocalDateTime end,
                                                                                              Long productId, Long brandId);


}
