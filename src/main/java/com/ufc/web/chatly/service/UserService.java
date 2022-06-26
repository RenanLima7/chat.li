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
}