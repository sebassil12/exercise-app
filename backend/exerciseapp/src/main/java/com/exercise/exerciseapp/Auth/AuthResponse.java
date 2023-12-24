package com.exercise.exerciseapp.Auth;

public class AuthResponse {
    String token;
    
    private AuthResponse(Builder builder) {
        this.token = builder.token;
    }


    public String getToken(){
        return this.token;
    }
    public void setToken(String token){
        this.token=token;
    }
    public static class Builder {
        private String token;

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public AuthResponse build() {
            return new AuthResponse(this);
        }
    }
    public Object Builder() {
        return null;
    }
    
}
