package com.dnb.devconnector.service;

import java.util.List;
import java.util.Optional;

import com.dnb.devconnector.dto.Profile;
import com.dnb.devconnector.dto.User;

public interface ProfileService {
	public Profile createProfile(Profile profile);
	public Iterable<Profile> getAllProfile(String userId);
	public Optional<Profile> getProfileById(String profileId);
	public boolean deleteProfileById(String profileID);
}
