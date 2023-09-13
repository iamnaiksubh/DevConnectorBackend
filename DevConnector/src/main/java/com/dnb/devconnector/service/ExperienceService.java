package com.dnb.devconnector.service;

import java.util.Optional;

import com.dnb.devconnector.dto.Experience;
import com.dnb.devconnector.dto.Profile;

public interface ExperienceService {
	public Experience createExperience(Experience experience);
	public Iterable<Experience> getAllExperienceByUserId(String userId);
	public Iterable<Experience> getAllExperienceByProfileId(String profileId);
	public boolean deleteProfileById(String profileID);
}
