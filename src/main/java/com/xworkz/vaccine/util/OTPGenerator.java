package com.xworkz.vaccine.util ;

import java.util.Random;

public class OTPGenerator {

	public static int generateOTP() {
		System.out.println("Invoked generateOTP()");
		Random random = new Random();
		int nextInt = 1000+random.nextInt(8999);

		return nextInt;
	}

	
	
}
