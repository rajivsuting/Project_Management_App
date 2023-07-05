package com.masai.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masai.main.entity.Role;
import com.masai.main.entity.UserRole;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	public Optional<Role> findByRoleName(UserRole roleName);

}
