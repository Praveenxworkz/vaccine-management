package com.xworkz.vaccine.service;

import org.springframework.stereotype.Service;

import com.xworkz.vaccine.entity.UserOTPEntity;

@Service
public interface RegistrationService {

public boolean validateEmailID(String emailID);
	
	public int getOTP();
	
	public boolean sendOTP(String emailID,int otp);
	
	public UserOTPEntity saveUserOTP(String emailID,int otp);
	
	public boolean compareOTP(String emailID,int otp);
	
	public boolean updateUserOTPByEmailID(String emailID,int newOtp);

	
}
