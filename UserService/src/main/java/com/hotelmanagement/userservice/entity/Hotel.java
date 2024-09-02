package com.hotelmanagement.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private int hotelId;

    private String name;

    private String location;

    private String about;
}
