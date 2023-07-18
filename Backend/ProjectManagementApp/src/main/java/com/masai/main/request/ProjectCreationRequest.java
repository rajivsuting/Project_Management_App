package com.masai.main.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.masai.main.entity.Task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectCreationRequest {
	
	private String name;
	private Set<Task> tasks;

}
