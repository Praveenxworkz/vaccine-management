package com.xworkz.vaccine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vaccine.entity.AddMemberEntity;
import com.xworkz.vaccine.service.AddMemberService;

@Controller
public class HomeController {

	@Autowired
	private AddMemberService addMemberService;

	@RequestMapping("/membersList")
	public String onClickGetMembersList(Model model) {
		System.out.println("Invoked onClickGetMembersList()");
		List<AddMemberEntity> allMemberDetails = this.addMemberService.getAllMemberDetails();
		model.addAttribute("MembersList", allMemberDetails);
		return "Home";
	}
	
}
