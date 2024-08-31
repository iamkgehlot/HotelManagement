package com.hotelmanagementservice.RatingService.service;

import com.hotelmanagementservice.RatingService.entity.Rating;
import com.hotelmanagementservice.RatingService.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userName) {
        return ratingRepository.findByUserName(userName);
    }

    @Override
    public List<Rating> getRatingByHotelId(int hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public List<Rating> createMultipleRating(List<Rating> rating) {
        return ratingRepository.saveAll(rating);
    }
}
