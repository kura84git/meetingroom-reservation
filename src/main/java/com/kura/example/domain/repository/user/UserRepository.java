package com.kura.example.domain.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kura.example.domain.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	
}
