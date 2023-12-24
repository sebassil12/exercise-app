package com.exercise.exerciseapp.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exercise.exerciseapp.Jwt.JwtService;
import com.exercise.exerciseapp.model.Role;
import com.exercise.exerciseapp.model.User;
import com.exercise.exerciseapp.repository.UserRepository;

@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthService (PasswordEncoder passwordEncoder, UserRepository userRepository, JwtService jwtService, AuthenticationManager authenticationManager) {
    this.passwordEncoder=passwordEncoder;
    this.userRepository=userRepository;
    this.jwtService=jwtService;
    this.authenticationManager=authenticationManager;
    }

    public AuthResponse login(LoginRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        AuthResponse authResponse = new AuthResponse.Builder().token(token).build();
        return authResponse;
    }

    public AuthResponse register(RegisterRequest register){
        User user = new User.Builder()
                    .username(register.getUsername())
                    .email(register.email)
                    .password(passwordEncoder.encode(register.getPassword()))
                    .role(Role.USER)
                    .build();
        userRepository.save(user);

        return new AuthResponse.Builder()
                .token(jwtService.getToken(user))
                .build();
    }

}
