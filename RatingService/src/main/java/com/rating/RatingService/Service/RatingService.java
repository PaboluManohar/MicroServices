package com.rating.RatingService.Service;

import com.rating.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {
    //create
    Rating create(Rating r);
    //get all ratings
    List<Rating> getRatings();

    //get all by user id
    List<Rating> getRatingByUserId(String id);
    //get all by hotel

    List<Rating> getRatingsByHotelId(String hotelId);
}
