package com.skyline.entity.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
 
   // @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
   // private Long id;
 
	@Id
    @Column(nullable = false, unique = true)
    private String username;
 
    private String password;

    
    public User(){}
	public User( String username, String password) {
		
		this.username = username;
		this.password = password;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
 
    
}
