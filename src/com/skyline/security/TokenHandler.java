package com.skyline.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.skyline.service.security.MyUserDetailsServiceImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public final class TokenHandler {

    private final String secret;
    
    //@Autowired
    private final MyUserDetailsServiceImpl userDetailsService;

    public TokenHandler(String secret, MyUserDetailsServiceImpl userDetailsService) {
        this.secret = secret;
        this.userDetailsService = userDetailsService;
    }

    public UserDetails parseUserFromToken(String token) {
        String username = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return userDetailsService.loadUserByUsername(username);
    }

    public String createTokenForUser(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}