package com.dnb.devconnector.dto;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.devconnector.utils.CustomUserIdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "education_seq")
	@GenericGenerator (name = "education_seq", strategy = "com.dnb.devconnector.utils.CustomEducationIdGenerator",
	parameters = {@Parameter(name = CustomUserIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomUserIdGenerator.VALUE_PREFIX_PARAMETER, value = "EDU_"),
			@Parameter(name = CustomUserIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})
	private String educationId;
	private String userId;
	private String profileId;
	private String schoolName;
	private String startDate;
	private String endDate;
	private boolean currentSchool = false;
	private String degree;
	private String fieldOfStudy;
	private String description;
}
