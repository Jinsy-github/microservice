package com.springboot.microservice.bookservice.dto;

import lombok.Data;

@Data
public class User {

    private Long id;
    private String firstName;
    private String lastName;
}
