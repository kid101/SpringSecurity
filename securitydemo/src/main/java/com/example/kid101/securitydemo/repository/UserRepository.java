package com.example.kid101.securitydemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kid101.securitydemo.model.User;;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByName(String userName);

}
