package com.dnb.devconnector.dto;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.devconnector.utils.CustomUserIdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "profile_seq")
	@GenericGenerator (name = "profile_seq", strategy = "com.dnb.devconnector.utils.CustomProfileIdGenerator",
	parameters = {@Parameter(name = CustomUserIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomUserIdGenerator.VALUE_PREFIX_PARAMETER, value = "PROFILE_"),
			@Parameter(name = CustomUserIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})
	private String profileId;
	private String userId;
	
//	@NotBlank(message = "profile name can't be blank")
	private String profileName;
	@NotBlank(message = "status or position can't be blank")
	private String professionalStatus;
	private String company;
//	@jakarta.validation.constraints.Pattern(regexp = "^(http|https)://[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z]{2,}(\\/[a-zA-Z0-9-]+)*(\\/[a-zA-Z0-9-]+\\.[a-zA-Z]{2,})?$")
	private String website;
	private String location;
	@NotBlank
	@jakarta.validation.constraints.Pattern(regexp = "^([a-zA-Z]+(,|$)){1,10}$")
	private String skills;
	@NotBlank
	private String githubUserName;
	private String profileBio;
//	@jakarta.validation.constraints.Pattern(regexp = "^(http|https)://[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z]{2,}(\\/[a-zA-Z0-9-]+)*(\\/[a-zA-Z0-9-]+\\.[a-zA-Z]{2,})?$")
	private String twitter;
//	@jakarta.validation.constraints.Pattern(regexp = "^(http|https)://[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z]{2,}(\\/[a-zA-Z0-9-]+)*(\\/[a-zA-Z0-9-]+\\.[a-zA-Z]{2,})?$")
	private String facebook;
//	@jakarta.validation.constraints.Pattern(regexp = "^(http|https)://[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z]{2,}(\\/[a-zA-Z0-9-]+)*(\\/[a-zA-Z0-9-]+\\.[a-zA-Z]{2,})?$")
	private String youtube;
//	@jakarta.validation.constraints.Pattern(regexp = "^(http|https)://[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z]{2,}(\\/[a-zA-Z0-9-]+)*(\\/[a-zA-Z0-9-]+\\.[a-zA-Z]{2,})?$")
	private String linkedin;
//	@jakarta.validation.constraints.Pattern(regexp = "^(http|https)://[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z]{2,}(\\/[a-zA-Z0-9-]+)*(\\/[a-zA-Z0-9-]+\\.[a-zA-Z]{2,})?$")
	private String instagarm;
	@Transient List<Experience> experience;
	@Transient List<Education> education;
	
	
}
