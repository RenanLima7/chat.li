package com.ufc.web.chatly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufc.web.chatly.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	Iterable<Message> findBySender(Long sender);
	
	Iterable<Message> findByAddressee(Long addressee);
}
