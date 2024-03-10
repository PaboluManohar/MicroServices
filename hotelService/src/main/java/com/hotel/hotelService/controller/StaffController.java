package com.hotel.hotelService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @GetMapping("/getStaff")
    public ResponseEntity<List<String>> getStaff()
    {
        List<String> samples = Arrays.asList("ram","sita","lakshman");
        return ResponseEntity.ok(samples);
    }
}
