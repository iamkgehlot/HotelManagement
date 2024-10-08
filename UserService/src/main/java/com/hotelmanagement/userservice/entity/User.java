package com.hotelmanagement.userservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userid;

    @Column(name = "username",unique = true)
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "about")
    private String about;

    @Transient
    private List<Rating> rating;


}
