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
public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "experience_seq")
	@GenericGenerator (name = "experience_seq", strategy = "com.dnb.devconnector.utils.CustomExperienceIdGenerator",
	parameters = {@Parameter(name = CustomUserIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomUserIdGenerator.VALUE_PREFIX_PARAMETER, value = "EXP_"),
			@Parameter(name = CustomUserIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})
	private String experienceId;
	private String userId;
	private String profileId;
	private String jobTitle;
	private String company;
	private String startDate;
	private String endDate;
	private boolean currentJob = false;
	private String description;
}
