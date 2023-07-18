package com.masai.main.service;


import java.util.List;

import com.masai.main.entity.Project;
import com.masai.main.request.ProjectCreationRequest;
import com.masai.main.response.ProjectCreationResponse;

public interface ProjectService {
	
	public ProjectCreationResponse createProject(ProjectCreationRequest request, String managerEmail);
	
	public Project getProjectById(Long id);
	
	public List<Project> getAllProjects();
	
	public ProjectCreationResponse deleteProject(Long id);

}
