package com.exercise.exerciseapp.Auth;

public class LoginRequest {
    String username;
    String password;

    public LoginRequest(String username, String password){
        this.username=username;
        this.password=password;
    }
    public LoginRequest(){

    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setPassword(String password){
        this.password=password;
    }
}
