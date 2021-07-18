package com.springboot.microservice.apiGateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod() {
        return "User Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/bookServiceFallBack")
    public String bookServiceFallBackMethod() {
        return "Book Service is taking longer than Expected." +
                " Please try again later";
    }
}
