package com.stars.userservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
class UserController {

    @PostMapping(value = "")
    public String hello(String name) {
        String result = name + UUID.randomUUID().toString();
        System.out.println(result);
        return result;
    }

}
