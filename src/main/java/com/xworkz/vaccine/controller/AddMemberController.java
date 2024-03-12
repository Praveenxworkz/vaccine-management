package com.xworkz.vaccine.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.xworkz.vaccine.dto.AddMemberDTO;
import com.xworkz.vaccine.service.AddMemberService;
import com.xworkz.vaccine.service.SignUpService;


@Controller
public class AddMemberController {

	@Autowired
	private AddMemberService addMemberService;

	@Autowired
	private SignUpService signUpService;

	@Autowired
	private SignUpController signUpController;

	@GetMapping("/addMember")
	public String getAddMemberpage() {
		return "Add-Member";
	}

	@PostMapping(value = "/addMember")
	public String onClickAddMember(@ModelAttribute AddMemberDTO addMemberDTO, Model model) {
		System.out.println("Invoked onClickAddMember()");
		if (this.addMemberService.validateMemberDetails(addMemberDTO)) {
			if (this.signUpService.memberCount(signUpController.getUserName())) {
				if (this.addMemberService.saveMemberDetails(addMemberDTO)) {
					model.addAttribute("savedMsg", "Member details saved successfully...Thank You!!");
					return "Home";
				} else {
					model.addAttribute("savedMsg", "Member details has not been saved...Try Again!!");
				}
			} else {
				model.addAttribute("MemberCountMsg", "You can add 6 members only.So Signup with another account");
			}
		} else {
			Map<String, String> map = this.addMemberService.map;
			model.addAttribute("validateName", map.get("NAME"));
			model.addAttribute("validateGender", map.get("GENDER"));
			model.addAttribute("validateDob", map.get("DOB"));
			model.addAttribute("validateId", map.get("ID"));
			model.addAttribute("validateIdNumber", map.get("IDNUMBER"));
			model.addAttribute("validateType", map.get("TYPE"));
			model.addAttribute("validateDoses", map.get("DOSES"));
		}

		return "Add-Member";
	}

	
}
