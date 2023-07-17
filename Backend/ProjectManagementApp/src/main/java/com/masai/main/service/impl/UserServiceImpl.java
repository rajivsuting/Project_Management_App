package com.masai.main.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.masai.main.entity.Role;
import com.masai.main.entity.UserEntity;
import com.masai.main.entity.UserRole;
import com.masai.main.exception.RoleException;
import com.masai.main.exception.UserException;
import com.masai.main.repository.RoleRepository;
import com.masai.main.repository.UserRepository;
import com.masai.main.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserEntity registerUser(String name, String email, String password, UserRole role) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new UserException("Username already exists");
        }

        UserEntity user = new UserEntity();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        
        Role userRole = roleRepository.findByRoleName(role)
                .orElseThrow(() -> new RoleException("Role not found"));

        user.setRoles(Collections.singleton(userRole));

        return userRepository.save(user);
	}

	@Override
	public List<UserEntity> getAllUsers() {
		
		List<UserEntity> allUsers= userRepository.findAll();
		
		if(allUsers.isEmpty()) throw new UserException("No user found");
		return allUsers;
		
	}

	@Override
	public UserEntity getUserByEmail(String email) {
		
		Optional<UserEntity> opt = userRepository.findByEmail(email);
		
		if(opt.isEmpty()) throw new UserException("No user found with email "+ email);
		
		return opt.get();
	}

	@Override
	public String deleteUser(String email) {
		
		Optional<UserEntity> opt = userRepository.findByEmail(email);
		if(opt.isEmpty()) throw new UserException("User not found with email "+email);
		UserEntity user = opt.get();
		userRepository.delete(user);
		
		return user.getName()+" is deleted successfully.";
		 
	}






}
