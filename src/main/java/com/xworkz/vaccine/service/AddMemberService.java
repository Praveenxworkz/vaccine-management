package com.xworkz.vaccine.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xworkz.vaccine.dto.AddMemberDTO;
import com.xworkz.vaccine.entity.AddMemberEntity;

@Service
public interface AddMemberService {

	Map<String, String> map = new HashMap<String, String>();
	
	public boolean validateMemberDetails(AddMemberDTO addMemberDTO);
	
	public boolean saveMemberDetails(AddMemberDTO addMemberDTO);
	
	public List<AddMemberEntity> getAllMemberDetails();


}
