package com.codecool.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JwtController {

    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials credentials) {

    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}