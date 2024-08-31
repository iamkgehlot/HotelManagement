package com.hotelmanagementservice.RatingService.controller;

import com.hotelmanagementservice.RatingService.entity.Rating;
import com.hotelmanagementservice.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class Controller {

    @Autowired
    RatingService ratingService;

    @PostMapping("/create-rating")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return new ResponseEntity<>(ratingService.createRating(rating), HttpStatus.OK);
    }
    @PostMapping("/create-multiple-rating")
    public ResponseEntity<List<Rating>> createMultipleRating(@RequestBody List<Rating> rating){
        return new ResponseEntity<>(ratingService.createMultipleRating(rating), HttpStatus.OK);
    }

    @GetMapping("/get-all-rating")
    public ResponseEntity<List<Rating>> getAllRating(){
        return new ResponseEntity<>(ratingService.getAllRating(),HttpStatus.OK);

    }

    @GetMapping("/get-rating-by-userid/{userName}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userName){
        return new ResponseEntity<>(ratingService.getRatingByUserId(userName),HttpStatus.OK);
    }

    @GetMapping("/get-rating-by-hotelid/{hoteID}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable int hoteID){
        return new ResponseEntity<>(ratingService.getRatingByHotelId(hoteID),HttpStatus.OK);
    }
}
