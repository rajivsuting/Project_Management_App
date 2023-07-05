package com.masai.main.request;

import com.masai.main.entity.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RegistrationRequest {
	
	private String name;
	private String email;
	private String password;
	private UserRole role;

}
