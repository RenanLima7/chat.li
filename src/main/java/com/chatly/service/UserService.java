package com.chatly.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chatly.common.BaseService;
import com.chatly.model.User;
import com.chatly.repository.UserRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.sun.jdi.InvalidTypeException;

@Service
public class UserService implements BaseService<User> {
	@Autowired
	UserRepository userRepository;

	private Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
			"cloud_name", "dqb1xxjrk", 
			"api_key", "982224412942239",
			"api_secret", "A81BjzJYHhsjN6LvKFUTx5sLc3c"
	));

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

	public Optional<Object> findByUserIdAndContactId(Long userId, Long contactId) {
		return userRepository.findByUserIdAndContactId(userId, contactId);
	}

	public Iterable<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public Iterable<User> findByName(String name) {
		return userRepository.findByName(name);
	}

	// public Iterable<User> findByMessage(String message) {
	// return userRepository.findByMessage(message);
	// }

	public Iterable<User> findBySource(String src) {
		return userRepository.findBySource(src);
	}

	public String sendUserImage(MultipartFile image, String email) throws InvalidTypeException, IOException {

		if (!isValidateImage(image)) {
			throw new InvalidTypeException();
		}

		Path path = Files.createTempFile("temp", image.getOriginalFilename());

		File file = path.toFile();
		image.transferTo(file);

		Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.asMap("folder", "chatly-profiles"));
		file.delete();

		return uploadResult.get("url").toString();
	}

	public boolean isValidateImage(MultipartFile image) {
		List<String> contentTypes = Arrays.asList("image/png", "image/jpg", "image/jpeg");

		for (int i = 0; i < contentTypes.size(); i++) {
			if (image.getContentType().toLowerCase().startsWith(contentTypes.get(i))) {
				return true;
			}
		}

		return false;
	}
}