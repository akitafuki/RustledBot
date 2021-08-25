package com.rustled.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatusController {
    @GetMapping("/status")
    public ResponseEntity getStatus() {
        return ResponseEntity.ok().build();
    }
}
