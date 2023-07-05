package com.masai.main.service;

import com.masai.main.entity.UserEntity;
import com.masai.main.entity.UserRole;

public interface UserService {
	
	public UserEntity registerUser(String name, String email, String password, UserRole role);

}
