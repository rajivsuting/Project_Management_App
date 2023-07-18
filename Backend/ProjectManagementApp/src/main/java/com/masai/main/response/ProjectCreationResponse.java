package com.masai.main.response;

import com.masai.main.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectCreationResponse {
	
	private Long id;
	private String name;
	private String managerName;

}
