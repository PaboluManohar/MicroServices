package com.user.service.UserService.exceptions;

import com.user.service.UserService.payLoad.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler
public ResponseEntity<ApiResponse> handlerResourceException(ResourcesNotFoundException ex )
    {
        String msg = ex.getMessage();
        ApiResponse apiResponse = ApiResponse.builder().message(msg).success(true).httpStatus(HttpStatus.NOT_FOUND).build();
        return new  ResponseEntity<ApiResponse>(apiResponse,apiResponse.getHttpStatus());
    }

}
