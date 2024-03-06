package com.example.Redis.service;

import com.example.Redis.Entity.User;

import java.util.List;

public interface UserService {
    User getUser(long id);
    User create(User user);
    List<User> getAll();
    User updateUser(User user);
    void deleteUser(long id);
}
