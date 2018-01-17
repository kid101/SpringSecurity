package com.example.kid101.securitydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kid101.securitydemo.model.Role;
import com.example.kid101.securitydemo.model.User;
import com.example.kid101.securitydemo.repository.UserRepository;
import com.google.common.collect.Sets;

@RequestMapping("/demo")
@RestController
public class DemoController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello!";
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/secured/hello")
	public String saySecuredHello() {
		return "Secured Hello!";
	}

	@RequestMapping("/saveuser/{username}" )
	public String sayHello(@PathVariable("username") String userName) {
		Role role = new Role("ADMIN");
		User user = new User();
		user.setRoles(Sets.newHashSet(role));
		user.setActive(1);
		user.setEmail("test@123");
		user.setName(userName);
		user.setLastName("singh");
		user.setPassword(new BCryptPasswordEncoder().encode("password"));
		userRepository.save(user);
		return "saved user!";
	}
}
