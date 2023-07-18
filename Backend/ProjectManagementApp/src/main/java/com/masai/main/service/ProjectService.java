package com.masai.main.service;

import com.masai.main.entity.Project;
import com.masai.main.request.ProjectCreationRequest;

public interface ProjectService {
	
	public Project createProject(ProjectCreationRequest request, String managerEmail);
	
	public String deleteProject(String name);

}
