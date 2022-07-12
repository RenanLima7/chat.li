package com.ufc.web.chatly.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.web.chatly.common.BaseService;
import com.ufc.web.chatly.model.User;
import com.ufc.web.chatly.repository.UserRepository;

@Service
public class UserService implements BaseService<User>{
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Iterable<User> getAll() {
		return userRepository.findAll();
	}

	@Transactional
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

	@Override
	public Optional<User> getById(Long id) {
		return userRepository.findById(id);
	}
	
	public Optional<User> getByEmail(String email) {
		return userRepository.getByEmail(email);
	}

	public Optional<User> getByEmailAndPassword(){
		return null;//userRepository.getByEmailAndPassword();
	}

	public Optional<Object> checkIfTheContactExists(Long userId, Long contactId) {		
		return userRepository.checkIfTheContactExists(userId, contactId);
	}
	
	//public User updateContacts(User user) {
		//return userRepository.updateContacts(user);
	//}

	public Iterable<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public Iterable<User> findByName(String name) {
		return userRepository.findByName(name);
	}
	
	//public Iterable<User> findByMessage(String message) {
		//return userRepository.findByMessage(message);
	//}
	
	public Iterable<User> findBySource(String src) {
		return userRepository.findBySource(src);
	}
}