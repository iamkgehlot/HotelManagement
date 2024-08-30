package com.hotelmanagement.userservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int userid;

    @Column(name = "username",unique = true)
    String username;

    @Column(name = "email")
    String email;

    @Column(name = "about")
    String about;

    @Transient
    List<Rating> rating;


}
