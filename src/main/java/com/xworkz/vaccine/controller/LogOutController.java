package com.xworkz.vaccine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LogOutController {

	@RequestMapping(value = "/logout",method=RequestMethod.GET)
	public String onClickLogout(HttpServletRequest request) {
		System.out.println("Invoked onClickLogout()");
		HttpSession httpSession = request.getSession(false);
		if(httpSession!=null) {
			httpSession.removeAttribute("UserName");
			httpSession.invalidate();	
		}
		return "Login";
	}
	
}
