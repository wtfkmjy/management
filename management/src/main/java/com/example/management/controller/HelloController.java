package com.example.management.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HelloController {
    @PreAuthorize("hasAuthority('竹官')")
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/hi")
    public String hi(){
        return "hi";
    }
}
