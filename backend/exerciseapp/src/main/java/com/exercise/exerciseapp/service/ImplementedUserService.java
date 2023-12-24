package com.exercise.exerciseapp.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.exerciseapp.model.User;
import com.exercise.exerciseapp.model.DTO.UserDTO;
import com.exercise.exerciseapp.repository.UserRepository;



@Service
public class ImplementedUserService implements UserService {

    private final UserRepository userRepository;
    @Autowired
    public ImplementedUserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDTO getUser(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        if(user != null){
            UserDTO userDTO = new UserDTO.Builder()
            .username(user.getUsername())
            .email(user.getEmail())
            .isActive(user.getIsActive())
            .build();
            return userDTO;
        }
        return null;
    }

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(Integer userId, User user) {
        User existingUser = userRepository.findById(userId)
        .orElseThrow(() -> new RuntimeException("User not found with id" + userId));

        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());

        userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        User eliminatedUser = userRepository.findById(userId)
        .orElseThrow(() -> new RuntimeException("The user doesn't exists"));

        eliminatedUser.setIsActive(false);

        userRepository.save(eliminatedUser);
    }
    
    
}
