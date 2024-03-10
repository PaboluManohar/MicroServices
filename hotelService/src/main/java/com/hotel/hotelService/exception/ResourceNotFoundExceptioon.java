package com.hotel.hotelService.exception;

public class ResourceNotFoundExceptioon extends RuntimeException {
    public ResourceNotFoundExceptioon(String s) {
        super(s);
    }
    public ResourceNotFoundExceptioon() {
        super("something went wrong");
    }
}
