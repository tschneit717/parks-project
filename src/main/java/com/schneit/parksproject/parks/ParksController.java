package com.schneit.parksproject.parks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parks")

public class ParksController {
    @Autowired
    private final ParksRepository parksRepository;

    @GetMapping("/hello")
    public String hello() {
        return parksRepository.getResult();
    }
}
