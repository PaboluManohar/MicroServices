package com.user.service.UserService.Service.impl;

import com.user.service.UserService.Repository.UserRepository;
import com.user.service.UserService.Service.UserService;
import com.user.service.UserService.entities.Hotel;
import com.user.service.UserService.entities.Rating;
import com.user.service.UserService.entities.User;
import com.user.service.UserService.exceptions.ResourcesNotFoundException;
import com.user.service.UserService.external.service.Hotelservice;
import com.user.service.UserService.external.service.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository ur;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Hotelservice hs;
    @Autowired
    private RatingService rs;
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User u) {

        u.setUserId(UUID.randomUUID().toString());
        User user =ur.save(u);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> allUsers =ur.findAll();
        return allUsers;
    }

    @Override
    public User getUser(String Uid) {
       User user = ur.findById(Uid).orElseThrow(()-> new ResourcesNotFoundException("there are no such users"));

       // have to call this :http://localhost:8083/ratings/users/15a4eeee-6b9e-424a-99dd-d00697ed8396
        Rating[] ratingsOfUsers= restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(),Rating[].class );

//        ResponseEntity<List<Rating>> rr = rs.getRating(user.getUserId());
//        System.out.println("====================="+rr);
//        System.out.println("#######################################################################");
//        System.out.println(rr.getBody());
//        System.out.println("#######################################################################");
//        int i=0;
//        for (Rating rrr :rr.getBody())
//        {
//            System.out.println("------------------------");
//            System.out.println(rrr.toString());
//            System.out.println("-------------------------");
//        }

        List<Rating> ratings = Arrays.stream(ratingsOfUsers).toList();
        logger.info("{}",ratings);
        System.out.println("______"+ratings+"_____"); //we can use toString to represent rating

       List<Rating> ratingList= ratings.stream().map(r -> {
            //fetch the rating
            //fetch the hotel rating using hotelId
            //http://localhost:8082/hotels/64c65613-869f-49f2-9dbb-d616ed43c4c0
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + r.getHotelId(), Hotel.class);
           // Hotel h = forEntity.getBody();
           Hotel h = hs.getHotel(r.getHotelId());
            System.out.println("__________________"+h+"______________");
            //set the hotel rating to rating (r)
            r.setHotel(h);
            //return the rating
            return r;


        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }
}
