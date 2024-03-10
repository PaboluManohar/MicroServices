package com.hotel.hotelService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundExceptioon.class)
    public ResponseEntity<Map<String,Object>> notFoundHandler(ResourceNotFoundExceptioon e)
    {
        Map<String,Object> map = new HashMap<>();
        map.put("message",e.getMessage());
        map.put("success",false);
        map.put("status", HttpStatus.NOT_FOUND);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);

    }
}
