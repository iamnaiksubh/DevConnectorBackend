package com.dnb.devconnector.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.devconnector.dto.Profile;

@Repository
public interface ProfileRepository extends  CrudRepository<Profile, String>{
	Iterable<Profile> findByUserId(String userId);
}
