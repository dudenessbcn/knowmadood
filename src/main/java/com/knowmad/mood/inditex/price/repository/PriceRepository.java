package com.knowmad.mood.inditex.price.repository;

import com.knowmad.mood.inditex.price.entity.Price;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created by dani on 11/26/24
 */
public interface PriceRepository extends CrudRepository<Price, Long> {

    Optional<Price> findTopByOrderByPriorityDescAndProductIdAndBrandIdAndPlacedAtBetween(Long productId,
                                                                                         Long brandId,
                                                                                         LocalDateTime date);


}
