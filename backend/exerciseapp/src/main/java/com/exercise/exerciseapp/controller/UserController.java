package com.exercise.exerciseapp.controller;


import java.util.List;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.exerciseapp.model.User;
import com.exercise.exerciseapp.service.ImplementedUserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final ImplementedUserService userService;
    
    @Autowired
    public UserController(ImplementedUserService userService){
        this.userService=userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.allUsers(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Optional<User>> getSingleUser(@PathVariable Integer userId){
        return new ResponseEntity<Optional<User>>(userService.getUser(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createSingleUser(@RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity<User>(HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updatedSingleUser(@PathVariable Integer userId, @RequestBody User user){
        userService.updateUser(userId, user);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PatchMapping("/delete/{userId}")
    public ResponseEntity<User> deleteSingleUser(@PathVariable Integer userId){
        userService.deleteUser(userId);
        return new ResponseEntity<User>(HttpStatus.OK);
        
    }

    
}
