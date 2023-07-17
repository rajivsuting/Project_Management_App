package com.masai.main.component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.masai.main.entity.Role;
import com.masai.main.entity.UserRole;
import com.masai.main.repository.RoleRepository;

@Component
public class DataInitializer implements CommandLineRunner {
	
	@Autowired
    private RoleRepository roleRepository;



    @Override
    public void run(String... args) throws Exception {
        // Check if roles already exist
        if (roleRepository.count() == 0) {
            // Create and save the roles
            Role adminRole = new Role();
            adminRole.setRoleName(UserRole.ROLE_ADMIN);
            roleRepository.save(adminRole);

            Role userRole = new Role();
            userRole.setRoleName(UserRole.ROLE_USER);
            roleRepository.save(userRole);
        }
    }
}
