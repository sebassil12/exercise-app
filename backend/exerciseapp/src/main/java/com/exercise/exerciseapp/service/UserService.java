package com.exercise.exerciseapp.service;

import java.util.List;
import java.util.Optional;

import com.exercise.exerciseapp.model.User;

public interface UserService {
    public Optional<User> getUser(Integer userId);
    public List<User>allUsers();
    public void createUser(User user);
    public void updateUser(Integer userId, User user);
    public void deleteUser(Integer userId);

    
}