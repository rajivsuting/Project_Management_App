package com.masai.main.service;

import java.util.List;

import com.masai.main.entity.UserEntity;
import com.masai.main.entity.UserRole;

public interface UserService {
	
	public UserEntity registerUser(String name, String email, String password, UserRole role);
	
	public List<UserEntity> getAllUsers();
	
	public UserEntity getUserByEmail(String email);
	
	public String deleteUser(String email);

}
