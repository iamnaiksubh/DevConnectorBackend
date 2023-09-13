package com.dnb.devconnector.service;

import java.util.Optional;

import com.dnb.devconnector.dto.User;

public interface UserService {
	public User registerUser(User user);
	public Iterable<User> getAllUser();
	public Optional<User> getUserByEmail(String userEmail);
	public boolean deleteUserByUUID(String userUUID);
}
