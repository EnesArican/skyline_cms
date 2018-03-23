package com.skyline.dao.security;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.skyline.dao.daoInterface.UserDao;
import com.skyline.entity.security.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

	@Override
	@SuppressWarnings("rawtypes")
	public User findByUsername(String username) {
		System.out.println("Tryna get user from username and password");
		
		String encoded=new BCryptPasswordEncoder().encode("deneme");
		//System.out.println(encoded);
		
		
		Query query  = currentSession().createQuery("FROM User WHERE username = :username")
				.setParameter("username", username);
		
		System.out.println(query.toString());
		
		User user = (User)query.uniqueResult();
		
		return user;
				
		
		
	}

}




