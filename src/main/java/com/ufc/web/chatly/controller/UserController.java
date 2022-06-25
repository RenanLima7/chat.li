package com.ufc.web.chatly.controller;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufc.web.chatly.model.User;
import com.ufc.web.chatly.common.BaseController;
import com.ufc.web.chatly.common.BaseMessage;
import com.ufc.web.chatly.dto.UserDTO;
import com.ufc.web.chatly.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController implements BaseController<User, UserDTO>{
	@Autowired 
	UserService userService;
	
	
	@GetMapping
	public Iterable<User> getAll() {
		return userService.getAll();
	}

	@Transactional
	@PostMapping
	@Override
	public ResponseEntity<Object> save(@RequestBody @Valid UserDTO userDTO) {
		var user = new User();
		BeanUtils.copyProperties(userDTO, user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));		
	}

	@Transactional
	@PutMapping("/{id}")
	@Override
	public ResponseEntity<Object> update(@RequestBody @Valid UserDTO userDTO, @PathVariable(value = "id") UUID id) {
		Optional<User> userOptional = userService.getById(id);
		
		if (!userOptional.isPresent()) {
			return new ResponseEntity<Object>(new BaseMessage("No user found with id: " + id), HttpStatus.NOT_FOUND);
		}
		
		var user = userOptional.get();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
				
		// Verify
		user.setAvatar(userDTO.getAvatar());
		
		return ResponseEntity.status(HttpStatus.OK).body(userService.save(user));
	}

	@Transactional
	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
		Optional<User> userOptional = userService.getById(id);
		
		if (!userOptional.isPresent()) {
			return new ResponseEntity<Object>(new BaseMessage("No user found with id: " + id), HttpStatus.NOT_FOUND);
		}
		
		userService.delete(userOptional.get());
		return new ResponseEntity<Object>(new BaseMessage("User successfully deleted!"), HttpStatus.OK);	
	}

	@GetMapping("/{id}")
	@Override
	public Object getById(@PathVariable(value = "id") UUID id) {
		Optional<User> userOptional = userService.getById(id);
		
		if (!userOptional.isPresent()) {
			return new ResponseEntity<Object>(new BaseMessage("No user found with id: " + id), HttpStatus.NOT_FOUND);
		}
		return userOptional.get();
	}
}