package com.dnb.devconnector.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.devconnector.dto.Education;

@Repository
public interface EducationRepository extends CrudRepository<Education, String> {
	Iterable<Education> findByUserId(String userId);
	Iterable<Education> findByProfileId(String profileId);
}
