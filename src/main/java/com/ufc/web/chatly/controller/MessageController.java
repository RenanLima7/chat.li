package com.ufc.web.chatly.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufc.web.chatly.common.BaseController;
import com.ufc.web.chatly.dto.UserDTO;
import com.ufc.web.chatly.model.Message;
import com.ufc.web.chatly.model.User;
import com.ufc.web.chatly.service.MessageService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/message")
public class MessageController implements BaseController<User, UserDTO>{
	@Autowired 
	MessageService messageService;	
	
	@GetMapping("/{senderId}/{addresseeId}")
	public ResponseEntity<Iterable<Message>> findAllByContact(@PathVariable(value = "senderId") Long senderId, @PathVariable(value = "addresseeId") Long addresseeId) {
		ArrayList<Message> messages = new ArrayList<Message>();
		messages.addAll((Collection<? extends Message>) messageService.findBySender(senderId));
		messages.addAll((Collection<? extends Message>) messageService.findByAddressee(addresseeId));
		
		return ResponseEntity.status(HttpStatus.OK).body(messages);
	}


	@Override
	public ResponseEntity<Object> update(UserDTO entity, Long id) {
		return null;
	}

	@Override
	public Object getById(Long id) {
		return null;
	}

	@Override
	public ResponseEntity<Iterable<User>> getAll() {
		return null;
	}


	@Override
	public ResponseEntity<Object> save(UserDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResponseEntity<Object> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}