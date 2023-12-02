package com.exercise.exerciseapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.exerciseapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{


    
}
