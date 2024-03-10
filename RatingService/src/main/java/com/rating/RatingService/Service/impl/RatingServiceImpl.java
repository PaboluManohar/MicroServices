package com.rating.RatingService.Service.impl;

import com.rating.RatingService.Repository.RatingRepository;
import com.rating.RatingService.Service.RatingService;
import com.rating.RatingService.entities.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository rr;
    @Override
    public Rating create(Rating r) {
        return rr.save(r);
    }

    @Override
    public List<Rating> getRatings() {
        return rr.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String id) {
        return rr.findByUserId(id);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return rr.findByHotelId(hotelId);
    }
}
