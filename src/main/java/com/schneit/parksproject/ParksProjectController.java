package com.schneit.parksproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParksProjectController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
