package com.dnb.devconnector.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.User;
import com.dnb.devconnector.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Iterable<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserByEmail(String userEmail) {
		return userRepository.findByUserEmail(userEmail);
	}

	@Override
	public boolean deleteUserByUUID(String userUUID) {
		if (userRepository.existsById(userUUID)) {
			userRepository.deleteById(userUUID);
			
			if (userRepository.existsById(userUUID))
				return true;
		}
		return false;
	}

}
