package com.hotelmanagement.userservice.controller;

import com.hotelmanagement.userservice.entity.User;
import com.hotelmanagement.userservice.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {

    @Autowired
    UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


    @GetMapping("/username/{username}")
    @CircuitBreaker(name="getUsernameCircuitbreaker",fallbackMethod = "getAllFallback")
    public ResponseEntity<User> getByUsername(@PathVariable String username){
        return new ResponseEntity<>(userService.getbyUsername(username),HttpStatus.OK);
    }

    public ResponseEntity<User> getAllFallback(String username, Exception ex){
       // ex.printStackTrace();
        User user=User.builder()
                .username("dummy")
                .email("dummy@mail.com")
                .about("dummy")
                .build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user),HttpStatus.OK);
    }

    @PostMapping("/dummydata")
    public ResponseEntity<List<User>> dumm(@RequestBody List<User> user){
        return new ResponseEntity<>(userService.saveMul(user),HttpStatus.OK);
    }

}
