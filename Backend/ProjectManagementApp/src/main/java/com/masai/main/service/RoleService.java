package com.masai.main.service;

import java.util.List;

import com.masai.main.entity.Role;
import com.masai.main.entity.UserRole;

public interface RoleService {
	
	public Role createRole(UserRole name);
	public List<Role> getAllRoles();
	public Role getRoleByName(UserRole name);
	public void deleteRoleByName(UserRole name);

}
