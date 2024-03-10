package com.hotel.hotelService.services;

import com.hotel.hotelService.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel h);
    List<Hotel> getAllHotels();

    Hotel getHotel(String id);

}
