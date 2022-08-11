package com.chatly.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatly.common.BaseController;
import com.chatly.dto.MessageDTO;
import com.chatly.model.Message;
import com.chatly.model.User;
import com.chatly.service.MessageService;
import com.chatly.service.UserService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "API REST Chat.ly - MESSAGE")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/message")
public class MessageController implements BaseController<Message, MessageDTO>{
	
	@Autowired 
	MessageService messageService;	
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<Iterable<Message>> findAllByContact(@PathVariable(value = "senderId") Long senderId, @PathVariable(value = "addresseeId") Long addresseeId) {
		ArrayList<Message> messages = new ArrayList<Message>();
		
		return ResponseEntity.status(HttpStatus.OK).body(messages);
	}

	@Override
	public ResponseEntity<Object> update(MessageDTO messageDTO, Long id) {
		return null;
	}

	@Override
	public Object getById(Long id) {
		return null;
	}

	@Override
	@GetMapping
	public ResponseEntity<Iterable<Message>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(messageService.getAll());
	}

	@Override
	@Transactional
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid MessageDTO messageDTO) {
		
		Optional<User> sender = userService.getById(messageDTO.getSenderId());
		
		if (!sender.isPresent()) {
			return new ResponseEntity<Object>(new String("No user found with id: " + messageDTO.getSenderId()), HttpStatus.NOT_FOUND);
		}
		
		Optional<User> addressee = userService.getById(messageDTO.getAddresseeId());
		
		if (!addressee.isPresent()) {
			return new ResponseEntity<Object>(new String("No user found with id: " + messageDTO.getAddresseeId()), HttpStatus.NOT_FOUND);
		}
		
		if (messageDTO.getSenderId() == messageDTO.getAddresseeId()) {
			return new ResponseEntity<Object>(new String("You can't talk to yourself!"), HttpStatus.CONFLICT);
		}
		
		/*if (!userService.findByUserIdAndContactId(messageDTO.getSenderId(), messageDTO.getSenderId()).isPresent()) {
			return new ResponseEntity<Object>(new BaseMessage("Contact not added!"), HttpStatus.CONFLICT);
		}*/
		
		Message message = new Message();
		BeanUtils.copyProperties(messageDTO, message);
		
		message.setCreatedDate(new Date());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(messageService.save(message));		
	}

	@Override
	public ResponseEntity<Object> delete(Long id) {
		return null;
	}
}