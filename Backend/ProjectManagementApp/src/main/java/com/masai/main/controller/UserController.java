package com.masai.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
    	return new ResponseEntity<String>("hello",HttpStatus.OK);
    }
    @GetMapping("/admin")
    public ResponseEntity<String> helloAdmin(){
    	return new ResponseEntity<String>("hello admin",HttpStatus.OK);
    }

}
