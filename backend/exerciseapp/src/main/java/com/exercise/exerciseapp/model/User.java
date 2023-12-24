package com.exercise.exerciseapp.model;



import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_app")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    Integer userId;
    String username;
    String email;
    String password;
    @Column(name = "is_active")
    Boolean isActive = true;
    @Enumerated(EnumType.STRING)
    Role role;

    public User(){

    }
    private User(Builder builder){
        this.userId=builder.userId;
        this.username=builder.username;
        this.email=builder.email;
        this.password=builder.password;
        this.role=builder.role;
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
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    }
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAccountNonExpired'");
    }
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAccountNonLocked'");
    }
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isCredentialsNonExpired'");
    }
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
    }
   
    //Class Builder
    public static class Builder{
        private Integer userId;
        private String username;
        private String email;
        private String password;
        @Enumerated(EnumType.STRING)
        private Role role;

        public Builder userId(Integer userId){
            this.userId=userId;
            return this;
        }
        public Builder username(String username){
            this.username=username;
            return this;
        }
        public Builder email(String email){
            this.email=email;
            return this;
        }
        public Builder password(String password){
            this.password=password;
            return this;
        }
        public Builder role(Role role){
            this.role=role;
            return this;
        }
        public User build(){
            return new User(this);
        }

    }

    public Object Builder(){
        return null;
    }
   

}
