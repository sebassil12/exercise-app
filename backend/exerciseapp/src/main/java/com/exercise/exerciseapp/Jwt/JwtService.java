package com.exercise.exerciseapp.Jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;

@Service
public class JwtService {
    private static final String SECRET_KEY = "USER1234EXERCISEAPP86E3272357538782F413F4428472B4B6250655368566B59703373367";

    //UserDetails interface represents core user information, encapsulates
    //user info, roles, aids authentication, auth and integrates with UserDetailsService
    public String getToken (UserDetails user){
        //HashMap is convenient way to pass arbitrary data because it allows
        //you to associate values with specific keys
        return getToken(new HashMap<>(), user);
    }

    private String getToken(Map<String, Object> extraClaim, UserDetails user){
        return Jwts
            .builder()
            .setClaims(extraClaim)
            .setSubject(user.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
            .signWith(getKey())
            //Responsible for compacting JWT
            .compact();
    }

    // Key for cryptographic keys
    private Key getKey(){
        //hmacShaKeyFor used in combination with the Keys class, create a secret key
        //suitable for HMAC algorithms
        byte[] KeyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(KeyBytes);
    }

    public String getUsernameFrom(String token){
        //::It is used to refer to a method without invoking
        return getClaim(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = getUsernameFrom(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Claims getAllClaims(String token){
        return Jwts
            .parserBuilder()
            .setSigningKey(getKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date getExpiration(String token){
        return getClaim(token,Claims::getExpiration);
    }
    private boolean isTokenExpired(String token){
        return getExpiration(token).before(new Date());
    }
}


