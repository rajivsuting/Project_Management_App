package com.masai.main.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	
	@Bean
	public SecurityFilterChain securityFilters(HttpSecurity http) throws Exception {
		
		
		http.authorizeHttpRequests(auth ->{ auth
			.requestMatchers(HttpMethod.POST, "/user/register").permitAll()
			.requestMatchers(HttpMethod.GET, "/role/create").permitAll()
			.requestMatchers(HttpMethod.GET, "/user/hello","/user/all","/user/**").hasRole("ADMIN")
			.requestMatchers(HttpMethod.POST, "/project/**").hasRole("ADMIN")
			.requestMatchers("/swagger-ui*/**","/v3/api-docs/**").permitAll()
			.anyRequest().authenticated();
				
		})
		.csrf(csrf -> csrf.disable())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		
		return http.build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


}
