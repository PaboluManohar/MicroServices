package com.user.service.UserService.external.service;

import com.user.service.UserService.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface Hotelservice
{
@GetMapping("/hotels/{hid}")
    public Hotel getHotel(@PathVariable("hid") String hotelId);


}
