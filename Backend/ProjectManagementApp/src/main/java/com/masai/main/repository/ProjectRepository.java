package com.masai.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.main.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	

}
