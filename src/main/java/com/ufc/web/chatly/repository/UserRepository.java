package com.ufc.web.chatly.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufc.web.chatly.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> getByEmail(String email);

	@Query(nativeQuery = true, value = "SELECT * FROM user_contacts "
			+ "WHERE user_id = :userId AND contact_id = :contact_id") // Validar o oposto  OR email LIKE '%:source%'") 
	Optional<Object> checkIfTheContactExists(@Param("user_id") Long userId, @Param("contact_id") Long contactId);

	Iterable<User> findByEmail(String email);
	
	Iterable<User> findByName(String name);

	//Iterable<User> findByMessage(String message);
	
	@Query(nativeQuery = true, value = "SELECT * FROM user WHERE name LIKE ':src'") 
	Iterable<User> findBySource(String src);
}
