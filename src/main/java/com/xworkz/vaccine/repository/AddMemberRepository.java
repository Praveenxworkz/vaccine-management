package com.xworkz.vaccine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccine.entity.AddMemberEntity;

@Repository
public interface AddMemberRepository extends JpaRepository<AddMemberEntity, Integer>{

}
