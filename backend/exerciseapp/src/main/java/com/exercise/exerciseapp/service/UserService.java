package com.exercise.exerciseapp.service;

import java.util.List;


import com.exercise.exerciseapp.model.User;
import com.exercise.exerciseapp.model.DTO.UserDTO;

public interface UserService {
    public UserDTO getUser(Integer userId);
    public List<User>allUsers();
    public void createUser(User user);
    public void updateUser(Integer userId, User user);
    public void deleteUser(Integer userId);

    
}