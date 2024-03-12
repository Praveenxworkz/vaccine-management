package com.xworkz.vaccine.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface ResetPasswordService {

	Map<String, String> map = new HashMap<String, String>();

	public boolean validatePassword(String userName, String password, String confirmPassword);

	public boolean updatePasswordByUserName(String password, String userName);

	public boolean sendUpdatedPassword(String password, String emailID);

}
