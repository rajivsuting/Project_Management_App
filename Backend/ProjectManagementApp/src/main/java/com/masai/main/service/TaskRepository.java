package com.masai.main.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.main.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
