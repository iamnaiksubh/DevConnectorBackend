package com.dnb.devconnector;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dnb.devconnector.dto.Education;
import com.dnb.devconnector.dto.Experience;
import com.dnb.devconnector.dto.Profile;
import com.dnb.devconnector.dto.User;
import com.dnb.devconnector.exceptions.InvalidEmailException;
import com.dnb.devconnector.exceptions.InvalidPasswordException;
import com.dnb.devconnector.service.EducationService;
import com.dnb.devconnector.service.ExperienceService;
import com.dnb.devconnector.service.ProfileService;
import com.dnb.devconnector.service.UserService;

@SpringBootApplication
public class DevConnectorApplication {

	private static UserService userService = null;
	private static ProfileService profileService = null;
	private static Scanner sc = new Scanner(System.in);
	private static User loggedInUser = null;
	private static Profile selectedProfile = null;
	private static ExperienceService experienceService = null;
	private static EducationService educationService = null;
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DevConnectorApplication.class, args);
		userService = applicationContext.getBean(UserService.class);
		profileService = applicationContext.getBean(ProfileService.class);
		experienceService = applicationContext.getBean(ExperienceService.class);
		educationService = applicationContext.getBean(EducationService.class);
		
		int choice = -1;
		do {
			System.out.println("Enter your choice : \n"
					+ "1. Register \n"
					+ "2. Login \n"
					+ "3. Exit");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1 -> userRegister();
			case 2 -> userLogin();
			case 3 -> {
				
			}
			}
		}while(choice != 3);
	}
	
	private static void userLogin() {
		System.out.println("Email Id :");
		String email = sc.next();
		System.out.println("Password :");
		String password = sc.next();
		
		Optional<User> user = userService.getUserByEmail(email);
		
		if (user.get().getPassword().equals(password)) {
			System.out.println("Logged in....");
			loggedInUser = user.get();
			
			showLoggedMenu();
		}else {
			System.out.println("Email or Password is incorrect...");
		}
		
	}
	private static void showLoggedMenu() {
		
		int choice = -1;
		
		do {
			System.out.println("Enter your choice : \n"
					+ "1. Create Profile \n"
					+ "2. Add User Education \n"
					+ "3. Add User Experience \n"
					+ "4. Developers \n"
					+ "5. Exit");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1 -> createProfile();
			case 2 -> addEducation(Entity.USER);
			case 3 -> addExperience(Entity.PROFILE);
			case 4 -> showDeveloper();
			case 5 -> {
				
			}
			}
		}while(choice != 5);
		
	}

	private static void showDeveloper() {
		Iterable<Profile> profiles = profileService.getAllProfile(loggedInUser.getUserId());
		
		profiles.forEach(profile -> {
			System.out.println(profile.getProfileName() + " " + profile.getProfessionalStatus() + " " + profile.getSkills());
		});
	}

	private static void addExperience(Entity entity) {
		Experience experience = new Experience();
		System.out.println("Enter job title:");
		experience.setJobTitle(sc.next());
		System.out.println("Enter company:");
		experience.setCompany(sc.next());
		System.out.println("Enter start date:");
		experience.setStartDate(sc.next());
		System.out.println("Enter end date:");
		experience.setEndDate(sc.next());
		System.out.println("Enter current job (T/F):");
		experience.setCurrentJob(sc.nextBoolean());
		System.out.println("Enter description:");
		experience.setDescription(sc.next());
		
		if (entity.value) {
			experience.setUserId(loggedInUser.getUserId());
			experienceService.createExperience(experience);
			return;
		}
		
		experience.setProfileId(selectedProfile.getProfileId());
		experienceService.createExperience(experience);
		
	}

	private static void addEducation(Entity entity) {
		Education education = new Education();
		System.out.println("Enter school name:");
		education.setSchoolName(sc.next());
		System.out.println("Enter degree:");
		education.setDegree(sc.next());
		System.out.println("Enter field of study:");
		education.setFieldOfStudy(sc.next());
		System.out.println("Enter start date:");
		education.setStartDate(sc.next());
		System.out.println("Enter end date:");
		education.setEndDate(sc.next());
		System.out.println("Enter current school (T/F):");
		education.setCurrentSchool(sc.nextBoolean());
		System.out.println("Enter description:");
		education.setDescription(sc.next());
		
		if (entity.value) {
			education.setUserId(loggedInUser.getUserId());
			educationService.createEducation(education);
			return;
		}
		
		education.setProfileId(selectedProfile.getProfileId());
		educationService.createEducation(education);
	}

	private static void createProfile() {
		
		System.out.println("Select Position :");
		System.out.println("1." + Position.DEVELOPER.value
				+ "\n2." + Position.JUNIOR_DEVELOPER.value
				+ "\n3." + Position.SENIOR_DEVELOPER
				+ "\n4." + Position.MANAGER.value
				+ "\n5." + Position.STUDENT_OR_LEARNING.value
				+ "\n6." + Position.INSTRUCTOR_OR_TEACHER.value
				+ "\n7." + Position.INTERN.value
				+"\n8." + Position.OTHER.value);
		
		int choice = sc.nextInt();
		Profile profile = new Profile();
		
		String positionValue = switch (choice) {
	    case 1 -> Position.DEVELOPER.value;
	    case 2 -> Position.JUNIOR_DEVELOPER.value;
	    case 3 -> Position.SENIOR_DEVELOPER.value;
	    case 4 -> Position.MANAGER.value;
	    case 5 -> Position.STUDENT_OR_LEARNING.value;
	    case 6 -> Position.INSTRUCTOR_OR_TEACHER.value;
	    case 7 -> Position.INTERN.value;
	    case 8 -> Position.OTHER.value;
	    default -> throw new IllegalArgumentException("Unexpected value: " + choice);
		};
		System.out.println("Enter Profile name:");
		profile.setProfileName(sc.next());
		profile.setProfessionalStatus(positionValue);
		
		System.out.println("Enter Company name:");
		profile.setCompany(sc.next());
		System.out.println("Enter Website:");
		profile.setWebsite(sc.next());
		System.out.println("Enter Location:");
		profile.setLocation(sc.next());
		System.out.println("Enter skills:");
		profile.setSkills(sc.next());
		System.out.println("Enter github user name:");
		profile.setGithubUserName(sc.next());
		System.out.println("Enter bio:");
		profile.setProfileBio(sc.next());
		System.out.println("Enter twitter:");
		profile.setTwitter(sc.next());
		System.out.println("Enter facebook:");
		profile.setFacebook(sc.next());
		System.out.println("Enter youtube:");
		profile.setYoutube(sc.next());
		System.out.println("Enter linkedin:");
		profile.setLinkedin(sc.next());
		System.out.println("Enter instagarm:");
		profile.setInstagarm(sc.next());
		profile.setUserId(loggedInUser.getUserId());
		profileService.createProfile(profile);
		selectedProfile = profile;
		showProfileMenu();
		
	}

	private static void showProfileMenu() {
		int choice = -1;
		
		do {
			System.out.println("Enter your choice : \n"
					+ "1. Add Profile Education \n"
					+ "2. Add Profile Experience \n"
					+ "3. Exit");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1 -> addEducation(Entity.PROFILE);
			case 2 -> addExperience(Entity.PROFILE);
			case 3 -> {
				
			}
			}
		}while(choice != 5);
	}

	private static void userRegister() {
		User user = new User();
		System.out.println("Name :");
		user.setUserName(sc.next());
		
		System.out.println("Email :");
		user.setUserEmail(sc.next());
			
		System.out.println("password :");
		user.setPassword(sc.next());
	
		userService.registerUser(user);
		return;
	}
	
	enum Position{
		DEVELOPER(1, "Developer"),
		JUNIOR_DEVELOPER(2, "Junior Developer"),
		SENIOR_DEVELOPER(3, "Senior Developer"),
		MANAGER(4, "Manager"),
		STUDENT_OR_LEARNING(5, "Student Or Learning"),
		INSTRUCTOR_OR_TEACHER(6, "Instructor Or Teacher"),
		INTERN(7, "Intern"),
		OTHER(8, "Other");
		
		int index;
		String value;
		Position(int index, String value){
			this.index = index;
			this.value = value;
		}
	}
	
	enum Entity{
		USER(true),
		PROFILE(false);
		
		boolean value;
		Entity(boolean value){
			this.value = value;
		}
		
	}

}
