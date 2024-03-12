package com.xworkz.vaccine.dto;

import lombok.Data;

@Data
public class AddMemberDTO {

	private String name;
	private String gender;
	private String dob;
	private String photoIdProof;
	private String photoIdNumber;
	private String vaccineType;
	private String dose;
	
}
