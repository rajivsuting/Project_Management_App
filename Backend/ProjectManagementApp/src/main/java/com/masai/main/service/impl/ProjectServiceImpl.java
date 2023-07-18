package com.masai.main.service.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.main.entity.Project;
import com.masai.main.entity.Task;
import com.masai.main.entity.UserEntity;
import com.masai.main.exception.ProjectException;
import com.masai.main.exception.UserException;
import com.masai.main.repository.ProjectRepository;
import com.masai.main.repository.UserRepository;
import com.masai.main.request.ProjectCreationRequest;
import com.masai.main.response.ProjectCreationResponse;
import com.masai.main.service.ProjectService;


import jakarta.transaction.Transactional;


@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private UserRepository userRepository;


	@Override
	@Transactional
	public ProjectCreationResponse createProject(ProjectCreationRequest request, String managerEmail) {
		
        if (request == null || StringUtils.isEmpty(request.getName())) {
            throw new IllegalArgumentException("Invalid project creation request");
        }

        // Find manager by email
        UserEntity manager = userRepository.findByEmail(managerEmail)
                .orElseThrow(() -> new UserException("No user found with email " + managerEmail));

        // Create the project and set manager
        Project project = new Project();
        project.setName(request.getName());
        project.setManager(manager);
        project.getMembers().add(manager);

        // Set tasks for the project
        Set<Task> tasks = request.getTasks();
        if (tasks != null && !tasks.isEmpty()) {
            for (Task task : tasks) {
                project.getTasks().add(task);
            }
        }
        // Save the project
        Project savedProject = projectRepository.save(project);
        return new ProjectCreationResponse(savedProject.getId(), savedProject.getName(), savedProject.getManager().getName());
	}

	



		@Override
		public Project getProjectById(Long id) {
			
			Project project = projectRepository.findById(id).orElseThrow(() ->
				new ProjectException("No project found with id "+id)
			);
			
			return project;
		}


		@Override
		public List<Project> getAllProjects() {
			
			List<Project> allProjects = projectRepository.findAll();
			if(allProjects.isEmpty()) throw new ProjectException("No projects found.");
			
			return allProjects;
		}
		
		
		@Override
		public ProjectCreationResponse deleteProject(Long id) {
			
			Project project = projectRepository.findById(id).orElseThrow(() ->
				new ProjectException("No project found with id "+id)
			);
			projectRepository.delete(project);
			return new ProjectCreationResponse(project.getId(), project.getName(), project.getManager().getName());
		}

}
