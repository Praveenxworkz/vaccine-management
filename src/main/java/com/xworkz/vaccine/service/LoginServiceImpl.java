package com.xworkz.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.entity.SignUpEntity;
import com.xworkz.vaccine.repository.SignUpRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private SignUpRepository signUpRepository;

	@Autowired
	private PasswordEncoder encoder;


	@Override
	public boolean validateUserNameAndPassword(String userName, String password) {
		System.out.println("Invoked validateUserNameAndPassword()");
		boolean validated = false;
		if (userName != null && !userName.isEmpty()) {
			validated = true;
		} else {
			validated = false;
			System.out.println("UserName is invalid");
			map.put("USERNAME", "UserName is invalid");
			return validated;
		}
		if (!password.isEmpty() && password != null) {
			validated = true;
		} else {
			validated = false;
			System.out.println("Password is invalid");
			map.put("PASSWORD", "Password is invalid");
			return validated;
		}
		return validated;
	}

	@Override
	public boolean verifyUsernameAndPassword(String userName, String userPassword) {
		System.out.println("Invoked verifyUsernameAndPassword()");
		SignUpEntity entity = this.signUpRepository.findEntityByUsername(userName);
		if (encoder.matches(userPassword, entity.getPassword())) {
			if (userName.equals(entity.getUserName())) {
				return true;
			} else {
				System.out.println("Username or password not matched");
				map.put("WRONGPASSWORD", "Username or password not matched");
				return false;
			}
		} else {
			System.out.println("Username or password not matched");
			map.put("WRONGPASSWORD", "Username or password not matched");
		}
		return false;
	}

	@Override
	public boolean loginAttempts(String userName, String password) {
		System.out.println("Invoked loginAttempts()");
		int attempts = this.signUpRepository.findLoginAttemptsByUsername(userName);
		attempts++;
		if (attempts <= 3) {
			this.signUpRepository.updateLoginAttemptsByUsername(userName, attempts);
			return true;
		} else {
			System.out.println("Your attempts exceeds limit..Account is blocked");
			map.put("ATTEMPTS", "Your attempts exceeds limit..Account is blocked");
		}
		return false;

	}

}
