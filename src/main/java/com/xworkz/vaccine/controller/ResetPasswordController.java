package com.xworkz.vaccine.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.ResetPasswordService;

@Controller
public class ResetPasswordController {

	@Autowired
	private ResetPasswordService resetPasswordService;

	@Autowired	
	private OTPController otpController;

	@GetMapping("/resetpassword")
	public String showResetPasswordForm() {
		return "ResetPassword";
	}

	@PostMapping("/resetpassword")
	public String onClickResetPassword(@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "password", required = false) String newPassword,
			@RequestParam(value = "confirmPassword", required = false) String confirmPassword, Model model) {
		System.out.println("Invoked onClickResetPassword()");
		if (this.resetPasswordService.validatePassword(userName, newPassword, confirmPassword)) {
			boolean updated = this.resetPasswordService.updatePasswordByUserName(newPassword, userName);
			boolean isSent = this.resetPasswordService.sendUpdatedPassword(newPassword, otpController.getEmail());
			if (updated && isSent) {
				model.addAttribute("validateUpdatedMsg",
						"Your new password has been saved and sent to mail successfully ");
				return "Login";
			} else {
				System.out.println("Mail has not been saved and sent to user");
				model.addAttribute("validateUpdatedMsg", "Mail has not been sent ");
			}
		} else {
			Map<String, String> map = this.resetPasswordService.map;
			model.addAttribute("validateUsername", map.get("USERNAME"));
			model.addAttribute("validatePassword", map.get("PASSWORD"));
			model.addAttribute("validateConfirmPassword", map.get("CONFIRMPASSWORD"));
			return "ResetPassword";
		}
		return "Login";
	}

	
}
