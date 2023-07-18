package com.masai.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.masai.main.entity.Project;
import com.masai.main.request.ProjectCreationRequest;
import com.masai.main.response.ProjectCreationResponse;
import com.masai.main.service.ProjectService;



@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/create/{managerEmail}")
	public ResponseEntity<ProjectCreationResponse> createProject(@RequestBody ProjectCreationRequest request, @PathVariable("managerEmail") String managerEmail ){
		
		return new ResponseEntity<ProjectCreationResponse>(projectService.createProject(request, managerEmail), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ProjectCreationResponse> deleteProjectById(@PathVariable("id") Long id){
		
		return new ResponseEntity<ProjectCreationResponse>(projectService.deleteProject(id), HttpStatus.OK);
	}

}
