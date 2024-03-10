package com.hotel.hotelService.repositories;

import com.hotel.hotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {


}
