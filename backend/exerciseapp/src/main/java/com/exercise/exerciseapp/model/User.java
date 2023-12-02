package com.exercise.exerciseapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_app")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userId;
    private String username;
    private String email;
    private String password;
    @Column(name = "is_active")
    private Boolean isActive = true;

    public User(){

    }
    public User( Integer userId, String username, String email, String password){
        this.userId=userId;
        this.username=username;
        this.email=email;
        this.password=password;
    }

    public Integer getId(){
        return userId;
    }
    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public Boolean getIsActive(){
        return isActive;
    }
    public void setId(Integer userId){
        this.userId=userId;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setIsActive(Boolean isActive){
        this.isActive=isActive;
    }
    @Override
    public String toString(){
        return "User{"+
                "userId="+userId+
                "username="+username+
                "email="+email+
                "password="+password+
                "}";
    }

}