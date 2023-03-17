package com.example.management.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/hi")
    public String hi(){
        return "hi";
    }
}
