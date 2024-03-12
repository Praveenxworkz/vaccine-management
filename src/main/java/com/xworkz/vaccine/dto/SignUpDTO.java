package com.xworkz.vaccine.dto;

import lombok.Data;

@Data
public class SignUpDTO {

	private String userName;
	private Long mobileNumber;
	private String gender;
	private String dateOfBirth;
	private String password;
	private String confirmPassword;
	
}
