package com.dnb.devconnector.dto;

import java.util.UUID;
import java.util.regex.Pattern;

import com.dnb.devconnector.exceptions.InvalidEmailException;
import com.dnb.devconnector.exceptions.InvalidPasswordException;
import com.dnb.devconnector.utils.CustomUserIdGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "user_seq")
	@GenericGenerator (name = "user_seq", strategy = "com.dnb.devconnector.utils.CustomUserIdGenerator",
	parameters = {@Parameter(name = CustomUserIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomUserIdGenerator.VALUE_PREFIX_PARAMETER, value = "USER_"),
			@Parameter(name = CustomUserIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})
	private String userId;
	
	@NotBlank(message = "user name can't be blank")
	private String userName;
	
	@Column(unique = true) 
	@jakarta.validation.constraints.Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
	private String userEmail;
	
	@NotBlank(message = "password can't be blank")
	@jakarta.validation.constraints.Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
	private String password;
	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	
}
