package com.dnb.devconnector.repo;

import org.springframework.stereotype.Repository;

import com.dnb.devconnector.dto.Experience;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface ExperienceRepository extends CrudRepository<Experience, String>{
	Iterable<Experience> findByUserId(String userId);
	Iterable<Experience> findByProfileId(String profileId);
}
