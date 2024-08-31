package com.hotelmanagementservice.RatingService.service;


import com.hotelmanagementservice.RatingService.entity.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {


    Rating createRating(Rating rating);

    List<Rating> getAllRating();

    List<Rating> getRatingByUserId(String userName);

    List<Rating> getRatingByHotelId(int hotelId);

    List<Rating> createMultipleRating(List<Rating> rating);
}
