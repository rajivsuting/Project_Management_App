package com.masai.main.service;

import com.masai.main.entity.Project;

public interface ProjectService {
	
	public Project createProject(Project project);
	
	public String deleteProject(String name);

}
