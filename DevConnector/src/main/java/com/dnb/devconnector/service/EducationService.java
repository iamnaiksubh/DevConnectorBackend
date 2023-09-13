package com.dnb.devconnector.service;

import com.dnb.devconnector.dto.Education;

public interface EducationService {
	public Education createEducation(Education education);
	public Iterable<Education> getAllEducationByUserId(String userId);
	public Iterable<Education> getAllEducationByProfileId(String profileId);
	public boolean deleteProfileById(String profileID);	
}
