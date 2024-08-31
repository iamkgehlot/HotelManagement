package com.hotelmanagementservice.RatingService.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int ratingId;
    private String userName;
    private int hotelId;
    private int rating;
    private String feedback;

}
