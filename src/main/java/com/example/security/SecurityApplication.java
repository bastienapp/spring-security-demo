package com.example.security;

import com.example.security.entity.Role;
import com.example.security.entity.User;
import com.example.security.repository.RoleRepository;
import com.example.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (roleRepository.findByName("ROLE_USER") == null) {
			roleRepository.save(new Role("ROLE_USER"));
		}
		if (roleRepository.findByName("ROLE_ADMIN") == null) {
			roleRepository.save(new Role("ROLE_ADMIN"));
		}
	}
}
