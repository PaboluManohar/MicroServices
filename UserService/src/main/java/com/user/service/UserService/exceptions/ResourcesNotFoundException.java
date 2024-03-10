package com.user.service.UserService.exceptions;

public class ResourcesNotFoundException extends RuntimeException{
    public ResourcesNotFoundException(){
        super("Resource not found");
    }

    public ResourcesNotFoundException(String msg){
        super(msg);
    }
}
