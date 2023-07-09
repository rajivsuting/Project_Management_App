package com.masai.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.main.entity.Role;
import com.masai.main.entity.UserRole;
import com.masai.main.repository.RoleRepository;
import com.masai.main.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role createRole(UserRole name) {
        if (roleRepository.findByRoleName(name).isPresent()) {
            throw new IllegalArgumentException("Role already exists");
        }

        Role role = new Role();
        role.setRoleName(name);
        return roleRepository.save(role);
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role getRoleByName(UserRole name) {
        return roleRepository.findByRoleName(name)
                .orElseThrow(() -> new RuntimeException("Role not found"));
	}

	@Override
	public void deleteRoleByName(UserRole name) {
        Role role = getRoleByName(name);
        roleRepository.delete(role);
	}

}
