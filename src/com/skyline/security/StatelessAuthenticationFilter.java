package com.skyline.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class StatelessAuthenticationFilter extends GenericFilterBean {

    private final TokenAuthenticationService authenticationService;

    public StatelessAuthenticationFilter(TokenAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Authentication authentication = authenticationService.getAuthentication(httpRequest);
        
        System.out.println("I think this is last line before error");
        System.out.println(authentication);
        System.out.println(authentication.getName());
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        
        System.out.println("1st dodgy code passed");
        
        filterChain.doFilter(request, response);
        SecurityContextHolder.getContext().setAuthentication(null);
        
        System.out.println("2st dodgy code passed");
        
        
        
      
        
    }
    
}



