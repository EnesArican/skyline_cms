package com.skyline.dao.daoInterface;

import com.skyline.entity.security.User;

public interface UserDao {
 
    User findByUsername(String username);

}
