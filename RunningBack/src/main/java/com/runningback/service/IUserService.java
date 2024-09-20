package com.runningback.service;

import com.runningback.entity.User;

public interface IUserService {

    void registerUser(User user);
    User getUserById(int id);
    User updateUser(int id, User user);
    int getAuthenticatedUser();


}
