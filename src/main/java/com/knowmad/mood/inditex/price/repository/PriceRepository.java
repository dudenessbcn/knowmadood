package com.knowmad.mood.inditex.price.repository;

import com.knowmad.mood.inditex.price.entity.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by dani on 11/26/24
 */
@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {

    List<Price> findByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(LocalDateTime start, LocalDateTime end,
                                                                                              Long productId, Long brandId);


}
