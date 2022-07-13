package com.ufc.web.chatly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ufc.web.chatly.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	Iterable<Message> findBySenderId(Long sender);
	
	Iterable<Message> findByAddresseeId(Long addressee);
	
	/*@Query(nativeQuery = true, value = "SELECT * FROM message "
	+ "WHERE userId = :userId AND contactId = :contactId")
	Iterable<Message> findBySenderIdAndAddresseeId(Long senderId, Long addresseeId);*/
}
