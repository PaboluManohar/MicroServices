package com.user.service.UserService.controllers;

import com.user.service.UserService.Service.impl.UserServiceImpl;
import com.user.service.UserService.entities.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl us;
    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User u = us.saveUser(user);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }
    int retry =1;
    @GetMapping("/{userId}")
    //@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallBack")
    //@Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallBack")
    @RateLimiter(name = "userRateLimitter",fallbackMethod = "ratingHotelFallBack" )
    public ResponseEntity<User> getSingelUser(@PathVariable String userId)
    {
//        System.out.println("get single user :"+ retry);
//        retry++;
        User u = us.getUser(userId);
        return ResponseEntity.ok(u);

    }
    //creating fallbackmethod for circuit breaker
    public ResponseEntity<User> ratingHotelFallBack(String UserId,Exception e)
    {
        System.out.println("fallBack method is executed because service is down"+e.getMessage());
        User u =User.builder().email("hello@gmail.com").
                name("dummy").
                about("fall back method is executed").
                userId("8765").build();

        return ResponseEntity.ok(u);

    }


    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers()
    {
       List<User> all = us.getAllUser();
       return ResponseEntity.ok(all);
    }

}
