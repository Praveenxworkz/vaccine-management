package com.xworkz.vaccine.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.dto.SignUpDTO;
import com.xworkz.vaccine.entity.SignUpEntity;
import com.xworkz.vaccine.repository.SignUpRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	private SignUpRepository signUpRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public boolean validateSignUpDTO(SignUpDTO signUpDTO) {
		System.out.println("Invoked validateSignUpDTO()");
		boolean validated = false;
		if (signUpDTO.getUserName() != null && !signUpDTO.getUserName().isEmpty()) {
			validated = true;
		} else {
			validated = false;
			System.out.println("Invalid User Name");
			map.put("USERNAME", "Invalid User Name");
			return validated;
		}
		if (signUpDTO.getMobileNumber() != null) {
			validated = true;
		} else {
			validated = false;
			System.out.println("Invalid Mobile Number");
			map.put("MOBILENUMBER", "Invalid Mobile Number");
			return validated;
		}
		if (!signUpDTO.getGender().isEmpty() && signUpDTO.getGender() != null) {
			validated = true;
		} else {
			validated = false;
			System.out.println("Invalid gender");
			map.put("GENDER", "Invalid gender");
			return validated;
		}
		if (signUpDTO.getDateOfBirth() != null && !signUpDTO.getDateOfBirth().isEmpty()) {
			validated = true;
		} else {
			validated = false;
			System.out.println("Invalid date of birth");
			map.put("DOB", "Invalid date of birth");
			return validated;
		}
		if (signUpDTO.getPassword() != null) {
			validated = true;
		} else {
			validated = false;
			System.out.println("Invalid password");
			map.put("PASSWORD", "Invalid password");
			return validated;
		}
		if (signUpDTO.getConfirmPassword() != null && signUpDTO.getPassword().equals(signUpDTO.getConfirmPassword())) {
			validated = true;
		} else {
			validated = false;
			System.out.println("Confirm password not matching");
			map.put("CONFIRMPASSWORD", "Confirm password not matching");
			return validated;
		}
		return validated;
	}

	@Override
	public boolean saveSignUpDTO(SignUpDTO signUpDTO) {
		System.out.println("Invoked saveSignUpDTO()");
		signUpDTO.setPassword(this.encoder.encode(signUpDTO.getPassword()));
		SignUpEntity signUpEntity = new SignUpEntity();
		BeanUtils.copyProperties(signUpDTO, signUpEntity);
		SignUpEntity entity = this.signUpRepository.save(signUpEntity);
		return true;
	}

	@Override
	public boolean sendUsernameAndPassword(String userName, String password, String emailID) {
		System.out.println("Invoked sendUsernameAndPassword()");
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(emailID);
		mailMessage.setSubject("Thank you for account creation in Vaccination Drive");
		mailMessage.setText("Your account has been created successfully.Following is your User Name:- " + userName+ " and Password:- " + password);
		mailSender.send(mailMessage);
		return true;
	}

	@Override
	public boolean memberCount(String userName) {
		System.out.println("Invoked memberCount()");
		int memberCount = this.signUpRepository.findMemberCountByUserName(userName);
		memberCount++;
		if(memberCount<=6) {
			this.signUpRepository.updateMemberCountByUserName(userName, memberCount);
			return true;
		}else {
			System.out.println("Cannot add more than 6 members");
		}
		return false;
	}


	



}
