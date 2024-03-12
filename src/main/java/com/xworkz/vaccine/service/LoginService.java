package com.xworkz.vaccine.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {
	
Map<String, String> map= new HashMap<String, String>();
	
	public boolean validateUserNameAndPassword(String userName,String password);
	
	public boolean verifyUsernameAndPassword(String userName,String userPassword);
	
	public boolean loginAttempts(String userName,String password);


}
