package com.dnb.devconnector.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.Education;
import com.dnb.devconnector.dto.Experience;
import com.dnb.devconnector.repo.EducationRepository;

@Service
public class EducationServiceImpl implements EducationService{
	
	@Autowired
	EducationRepository educationRepository;
	
	@Override
	public Education createEducation(Education education) {
		return educationRepository.save(education);
	}

	@Override
	public Iterable<Education> getAllEducationByUserId(String userId) {
		return educationRepository.findByUserId(userId);
	}

	@Override
	public Iterable<Education> getAllEducationByProfileId(String profileId) {
		// TODO Auto-generated method stub
		return educationRepository.findByProfileId(profileId);
	}

	@Override
	public boolean deleteProfileById(String profileID) {
		if (educationRepository.existsById(profileID)) {
			educationRepository.deleteById(profileID);
			
			if(!educationRepository.existsById(profileID))
				return true;
		}
		return false;
	}
	
}
