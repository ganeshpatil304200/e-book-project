package com.dao;

import com.entity.User;

public interface UserDao {
	public boolean userRegister(User us);

	public User  login(String email,String password); 
		
	
}