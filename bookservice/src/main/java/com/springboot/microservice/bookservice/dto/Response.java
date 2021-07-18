package com.springboot.microservice.bookservice.dto;

import com.springboot.microservice.bookservice.entity.Book;
import lombok.Data;

@Data
public class Response {

    private Book book;
    private User user;
}
