package com.xworkz.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.RegistrationService;

@Controller
public class OTPController {

	@Autowired
	private RegistrationService registrationService;

	private String email;

	public String getEmail() {
		return email;
	}

	
	@RequestMapping("/welcome")
	public String getPage() {
		return "VaccineRegistration";
	}

	@RequestMapping(value = "/getOTP", method = RequestMethod.POST)
	public String onClickProcessOTP(@RequestParam("emailID") String emailID, Model model) {
		System.out.println("Invoked onClickProcessOTP()");
		if (this.registrationService.validateEmailID(emailID)) {
			int otp = this.registrationService.getOTP();
			this.registrationService.saveUserOTP(emailID, otp);
			this.email = emailID;
			boolean isSent = this.registrationService.sendOTP(emailID, otp);
			if (isSent) {
				System.out.println("Mail has been saved and sent to user");
				model.addAttribute("SendingMessage", "OTP has been sent to your EmailID");
				return "VerifyOTP";
			} else {
				System.out.println("Mail has not been saved and sent to user");
				model.addAttribute("SendingMessage", "Mail has not been sent ");
			}
		} else {
			model.addAttribute("ValidationEmailID", "EmailID cannot be empty");
			return "VaccineRegistration";
		}
		return "VerifyOTP";
	}
	
}
