package com.hotelmanagement.HotelService.controller;

import com.hotelmanagement.HotelService.entity.Hotel;
import com.hotelmanagement.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class Controller {

    @Autowired
    HotelService hotelService;

    @GetMapping("/get-hotel/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable int hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelByid(hotelId));
    }

    @GetMapping("/get-all-hotel")
    public ResponseEntity<List<Hotel>>  getAllHotel(){
        return new ResponseEntity<>(hotelService.getAllHotel(),HttpStatus.OK);
    }

    @PostMapping("/create-hotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.createHotel(hotel),HttpStatus.OK);
    }

    @PostMapping("/create-listof-hotel")
    public ResponseEntity<List<Hotel>> insertMultipleHotels(@RequestBody List<Hotel> hotel){
        return new ResponseEntity<>(hotelService.insertMultipleHotels(hotel),HttpStatus.OK);
    }
}
