package com.example.kid101.securitydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.kid101.securitydemo.model.UserAuthWrapper;
import com.example.kid101.securitydemo.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return new UserAuthWrapper(userRepository.findByName(userName)
				.orElseThrow(() -> new UsernameNotFoundException("User Name not defined ")));
	}

}
