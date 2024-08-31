package com.hotelmanagementservice.RatingService.repository;

import com.hotelmanagementservice.RatingService.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Integer> {


    List<Rating> findByUserName(String username);
    List<Rating> findByHotelId(int hotelId);
}
