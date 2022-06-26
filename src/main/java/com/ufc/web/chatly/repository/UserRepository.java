package com.ufc.web.chatly.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufc.web.chatly.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> getByEmail(String email);
}
