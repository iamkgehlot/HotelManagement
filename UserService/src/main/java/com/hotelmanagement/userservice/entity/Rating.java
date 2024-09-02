package com.hotelmanagement.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    private int ratingId;
    private String userName;
    private int hotelId;
    private int rating;
    private String feedback;
    private Hotel hotel;
}
