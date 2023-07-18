package com.masai.main.service.impl;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.main.entity.Project;
import com.masai.main.entity.Task;
import com.masai.main.entity.UserEntity;
import com.masai.main.exception.UserException;
import com.masai.main.repository.ProjectRepository;
import com.masai.main.repository.UserRepository;
import com.masai.main.request.ProjectCreationRequest;
import com.masai.main.service.ProjectService;


import jakarta.transaction.Transactional;


@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private UserRepository userRepository;



	@Override
	public String deleteProject(String name) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	@Transactional
	public Project createProject(ProjectCreationRequest request, String managerEmail) {
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
                task.setProject(project);
                project.getTasks().add(task);
            }
        }

        // Save the project
        return projectRepository.save(project);
	}

}
