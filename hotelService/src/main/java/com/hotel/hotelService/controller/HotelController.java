package com.hotel.hotelService.controller;

import com.hotel.hotelService.entities.Hotel;
import com.hotel.hotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    HotelService hs;

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        Hotel h = hs.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(h);
    }

    @PreAuthorize("hasAuthority('SCOPE_internal')")
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable("id") String id )
    {
        Hotel h = hs.getHotel(id);
        return ResponseEntity.ok(h);
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    public ResponseEntity<List<Hotel>> getAllHotels()
    {
        List<Hotel> lh = hs.getAllHotels();
        return ResponseEntity.ok(lh);
    }
}
