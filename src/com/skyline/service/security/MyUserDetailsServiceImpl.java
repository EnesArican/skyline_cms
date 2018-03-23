package com.skyline.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.skyline.dao.daoInterface.UserDao;
import com.skyline.entity.security.User;
import com.skyline.service.shared.UserPrincipal;


public class MyUserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UserDao userDao;
 
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(user);
    }

}


