package com.xworkz.vaccine.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xworkz.vaccine.dto.SignUpDTO;

@Service
public interface SignUpService {

	Map<String, String> map = new HashMap<String, String>();

	boolean validateSignUpDTO(SignUpDTO signUpDTO);

	boolean saveSignUpDTO(SignUpDTO signUpDTO);

	public boolean sendUsernameAndPassword(String userName, String password, String emailID);
	
	public boolean memberCount(String userName);


}
