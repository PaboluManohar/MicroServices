package com.rating.RatingService.controller;

import com.rating.RatingService.Service.RatingService;
import com.rating.RatingService.entities.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService rs;
    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("")
    public ResponseEntity<Rating> create(@RequestBody Rating r)
    {
        Rating rating = rs.create(r);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating);

    }

    @GetMapping("")
    public  ResponseEntity<List<Rating>> getRatings()
    {
        return ResponseEntity.ok(rs.getRatings());
    }

    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping("/users/{userId}")
    public  ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable("userId") String userId)
    {
        return ResponseEntity.ok(rs.getRatingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public  ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable("hotelId") String HotelId)
    {
        return ResponseEntity.ok(rs.getRatingsByHotelId(HotelId));
    }
}
