package com.asset.avenues.UserDetailService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "QR Code Backend is running 🚀";
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
