package com.dnb.devconnector.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.Experience;
import com.dnb.devconnector.dto.Profile;
import com.dnb.devconnector.repo.ExperienceRepository;

@Service
public class ExperienceServiceImpl implements ExperienceService{
	@Autowired
	ExperienceRepository experienceRepository;
	
	@Override
	public Experience createExperience(Experience experience) {
		return experienceRepository.save(experience);
	}

	@Override
	public Iterable<Experience> getAllExperienceByUserId(String userId) {
		return experienceRepository.findByUserId(userId);
	}

	@Override
	public Iterable<Experience> getAllExperienceByProfileId(String profileId) {
		// TODO Auto-generated method stub
		return experienceRepository.findByProfileId(profileId);
	}

	@Override
	public boolean deleteProfileById(String profileID) {
		if (experienceRepository.existsById(profileID)) {
			experienceRepository.deleteById(profileID);
			
			if(!experienceRepository.existsById(profileID))
				return true;
		}
		return false;
	}
	
}
