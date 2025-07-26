package com.rafael.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private Long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
