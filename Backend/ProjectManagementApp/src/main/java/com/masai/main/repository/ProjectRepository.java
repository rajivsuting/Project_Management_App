package com.masai.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.main.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	Optional<Project> findByName(String name);

}
