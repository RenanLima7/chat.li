package com.ufc.web.chatly.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.web.chatly.common.BaseService;
import com.ufc.web.chatly.model.Message;
import com.ufc.web.chatly.repository.MessageRepository;

@Service
public class MessageService implements BaseService<Message>{
	
	@Autowired
	MessageRepository messageRepository;

	@Override
	public Iterable<Message> getAll() {
		return messageRepository.findAll();
	}
	
	@Override
	public Message save(Message message) {
		return messageRepository.save(message);
	}
	
	@Override
	public void delete(Message message) {
		//messageRepository.delete(message);
	}

	@Override
	public Optional<Message> getById(Long id) {
		return null;
	}
		
	public Iterable<Message> findBySenderId(Long id) {
		return messageRepository.findBySenderId(id);
	}
	
	public Iterable<Message> findByAddresseeId(Long id) {
		return messageRepository.findByAddresseeId(id);
	}
	
	/*public Iterable<Message> findBySenderIdAndAddresseeId(Long senderId, Long addresseeId) {
		return messageRepository.findBySenderIdAndAddresseeId(senderId, addresseeId);
	}*/
}
