package com.exercise.exerciseapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.exerciseapp.repository.UserRepository;

@Service
public class ImplAuthService implements AuthService {
    
    private final UserRepository userRepository;
    
    
    @Autowired
    public ImplAuthService( UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public void Register() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Register'");
    }

    @Override
    public void Auth() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Auth'");
    }
    
}
