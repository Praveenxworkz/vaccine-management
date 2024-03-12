package com.xworkz.vaccine.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	
	
	@RequestMapping("/getLogin")
	public String getLoginPage() {
		return "Login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String onClickLogin(@RequestParam("userName") String userName, @RequestParam("password") String userPassword,
			HttpServletRequest request, Model model) {
		System.out.println("Invoked onClickLogin()");
		Map<String, String> map = this.loginService.map;
		if (this.loginService.validateUserNameAndPassword(userName, userPassword)) {
			if (this.loginService.verifyUsernameAndPassword(userName, userPassword)) {
				model.addAttribute("verifyMessage", "Successfully logged In... Thank You");
				HttpSession session = request.getSession(true);
				session.setAttribute("UserName", userName);
				model.addAttribute("username", userName);
				return "Home";
			} else if (this.loginService.loginAttempts(userName, userPassword)) {
				model.addAttribute("Wrongpassword", map.get("WRONGPASSWORD"));
				return "Login";
			} else {
				model.addAttribute("LoginAttempts", map.get("ATTEMPTS"));
				return "Login";
			}
		} else {
			model.addAttribute("validateUserName", map.get("USERNAME"));
			model.addAttribute("validatePassword", map.get("PASSWORD"));
		}
		return "Login";
	}
	
}
