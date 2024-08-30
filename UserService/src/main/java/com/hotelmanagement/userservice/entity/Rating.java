package com.hotelmanagement.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    String userid;
    String hotelid;
    String rating;
    String feedback;
}
