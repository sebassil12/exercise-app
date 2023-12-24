package com.exercise.exerciseapp.model.DTO;

public class UserDTO {
    String username;
    String email;
    Boolean isActive;

    public UserDTO(){}
    private UserDTO(Builder builder){
        this.username=builder.username;
        this.email=builder.email;
        this.isActive=builder.isActive;
    }

    public String getUsername(){
        return this.username;
    }

    public String getEmail(){
        return this.email;
    }

    public Boolean getisActive(){
        return this.isActive;
    }

    public static class  Builder {
        private String username;
        private String email;
        private Boolean isActive;
        
        public Builder username(String username){
            this.username=username;
            return this;
        }

        public Builder email(String email){
            this.email=email;
            return this;
        }

        public Builder isActive(Boolean isActive){
            this.isActive=isActive;
            return this;
        }

        public UserDTO build(){
            return new UserDTO(this);
        }

    }

    public Object Builder(){
        return null;
    }
}
