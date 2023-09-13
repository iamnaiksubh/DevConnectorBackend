package com.dnb.devconnector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.Profile;
import com.dnb.devconnector.dto.User;
import com.dnb.devconnector.repo.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService{
	
	@Autowired
	ProfileRepository profileRepository;

	@Override
	public Profile createProfile(Profile profile) {
		return profileRepository.save(profile);
	}

	@Override
	public Iterable<Profile> getAllProfile(String userId) {
		return profileRepository.findByUserId(userId);
	}

	@Override
	public Optional<Profile> getProfileById(String profileId) {
		return profileRepository.findById(profileId);
	}

	@Override
	public boolean deleteProfileById(String profileID) {
		if (profileRepository.existsById(profileID)) {
			profileRepository.deleteById(profileID);
			
			if(!profileRepository.existsById(profileID))
				return true;
		}
		return false;
	}

	

	
	
	
}
