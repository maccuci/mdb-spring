package com.maccuci.spring.controller;

import com.maccuci.spring.entity.dao.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchedulesController {

    @GetMapping("/api/schedules")
    public ResponseEntity<String> schedule() {
        return ResponseEntity.ok("Schedule #1");
    }
}
