package com.user.service.UserService.external.service;

import com.user.service.UserService.entities.Hotel;
import com.user.service.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "Rating-SERVICE")
public interface RatingService
{
    @GetMapping("ratings/users/{uid}")
    public ResponseEntity<List<Rating>> getRating(@PathVariable("uid") String uid);


    @PostMapping("/ratings")
    public Rating createRating(Rating r);

    @PutMapping("/ratings/{rid}")
    public Rating UpdateRating(@PathVariable String rid, @RequestBody Rating rating);

//    @DeleteMapping("/ratings/{rid}")
//    public void deleteRating(@PathVariable("rid") String rid);

}
