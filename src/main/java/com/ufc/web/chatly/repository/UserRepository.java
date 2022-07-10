package com.ufc.web.chatly.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ufc.web.chatly.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> getByEmail(String email);

	// Optional<User> getByEmailAndPassword();

	@Query(nativeQuery = true, value = "SELECT UC.* FROM user_contacts AS UC " 
			+ "WHERE UC.user_id = :userId AND UC.contact_id = :contactId ") // Validar o oposto
	Optional<Object> checkIfTheContactExists(Long userId, Long contactId);
}
