package com.in28minutes.unittesting.unittesting.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @GetMapping("/test")
    public String myApi() {
        return "{\"msg\":\"india is great\"}";
    }
}
