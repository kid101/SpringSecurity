package com.example.tushar.securitydemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tushar.securitydemo.model.User;;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByName(String userName);

}
