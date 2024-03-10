package com.hotel.hotelService.services.impl;

import com.hotel.hotelService.entities.Hotel;
import com.hotel.hotelService.exception.ResourceNotFoundExceptioon;
import com.hotel.hotelService.repositories.HotelRepository;
import com.hotel.hotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hr;
    @Override
    public Hotel createHotel(Hotel h) {
        h.setId(UUID.randomUUID().toString());
       Hotel hotel = hr.save(h);
       return hotel;

    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> all =hr.findAll();
        return all;
    }

    @Override
    public Hotel getHotel(String id) {
        Hotel hotel = hr.findById(id).orElseThrow(() -> new ResourceNotFoundExceptioon("there is no such an exception"));
        return hotel;
    }
}
