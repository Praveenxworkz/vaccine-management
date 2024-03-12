package com.xworkz.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.RegistrationService;

@Controller
public class VerifyOTPController {

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private OTPController otpController;

	@RequestMapping("/processOTP")
	public String onClickVerifyAndProcess(@RequestParam("otp") int otp, Model model) {
		System.out.println("Invoked onClickVerifyAndProcess()");
		boolean compareOTP = this.registrationService.compareOTP(otpController.getEmail(), otp);
		if (compareOTP) {
			System.out.println("OTP verified successfully");
			return "Sign-Up";
		} else {
			model.addAttribute("ProcessMessage", "Your OTP is not valid");
			System.out.println("OTP is not valid");
			return "VaccineRegistration";
		}
	}
	

	@RequestMapping("/resendOTP")
	public String onClickResendOTP(Model model) {
		System.out.println("Invoked onClickResendOTP()");
		int newOTP = this.registrationService.getOTP();
		boolean updated = this.registrationService.updateUserOTPByEmailID(otpController.getEmail(), newOTP);
		boolean isSent = this.registrationService.sendOTP(otpController.getEmail(), newOTP);
		if (updated && isSent) {
			model.addAttribute("ResendingOTP", "OTP is resended to your mail");
			return "VerifyOTP";
		} else {
			model.addAttribute("ResendingOTP", "OTP is not sent..Try again!!");
			return "VerifyOTP";
		}
	}

	
}
