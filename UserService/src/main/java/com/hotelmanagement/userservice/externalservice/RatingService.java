package com.hotelmanagement.userservice.externalservice;

import com.hotelmanagement.userservice.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="RATINGSERVICE")
public interface RatingService {

    @GetMapping("/rating/get-rating-by-userid/{userName}")
    List<Rating> getRatingByUserId(@PathVariable String userName);
}
