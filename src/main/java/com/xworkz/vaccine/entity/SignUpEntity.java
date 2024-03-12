package com.xworkz.vaccine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vaccine_signup")
public class SignUpEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	private Long mobileNumber;
	private String gender;
	private String dateOfBirth;
	private String password;
	private int loginAttempts;
	private int memberCount;
	
}
