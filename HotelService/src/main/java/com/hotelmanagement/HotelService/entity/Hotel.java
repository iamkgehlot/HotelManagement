package com.hotelmanagement.HotelService.entity;

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
public class Hotel {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int hotelId;

    private String name;

    private String location;

    private String about;
}
