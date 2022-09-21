package com.blogapp;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.blogapp.Entity.Role;
import com.blogapp.repository.RoleRepo;

@SpringBootApplication
public class BlogAppApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BlogAppApplication.class, args);
	}
	
	@Bean
	public ModelMapper modeMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		String password="Praveen123";
		String encodedPassword=passwordEncoder.encode("Praveen123");
		System.out.println(encodedPassword);
		
		Role role= new Role();
		role.setId(502);
		role.setRole("ADMIN_USER");
		
		Role role1= new Role();
		role1.setId(501);
		role1.setRole("NORMAL_USER");
		
		List<Role> roles=List.of(role,role1);
		List<Role> result=roleRepo.saveAll(roles);
		
		result.forEach(r-> System.out.println(r.getRole()));
		
	}

}
