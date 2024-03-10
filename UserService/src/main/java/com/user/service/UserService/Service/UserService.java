package com.user.service.UserService.Service;

import com.user.service.UserService.entities.User;

import java.util.List;

public interface UserService {
    //user operations
    User saveUser(User u);
    List<User> getAllUser();
    User getUser(String Uid);

}
