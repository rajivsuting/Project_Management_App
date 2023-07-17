package com.masai.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.main.entity.UserEntity;
import com.masai.main.request.RegistrationRequest;
import com.masai.main.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
    @PostMapping("/register")
    public ResponseEntity<UserEntity> registerUser(@RequestBody RegistrationRequest request) {

        UserEntity user = userService.registerUser(request.getName(), request.getEmail(), request.getPassword(), request.getRole());
        return  new ResponseEntity<UserEntity>(user, HttpStatus.CREATED);

    }
    
    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAllUsers(){
    	
    	return 	new ResponseEntity<List<UserEntity>>(userService.getAllUsers(), HttpStatus.OK);
    }
    
    @GetMapping("/{email}")
    public ResponseEntity<UserEntity> getUserByEmail(@PathVariable("email") String email){
    	
    	return new ResponseEntity<UserEntity>(userService.getUserByEmail(email), HttpStatus.OK);
    }
    
    public ResponseEntity<String> deleteUser(@PathVariable("email") String email){
    	
    	return new ResponseEntity<String>(userService.deleteUser(email), HttpStatus.OK);
    }
    

}
