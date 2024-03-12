package com.xworkz.vaccine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccine.entity.SignUpEntity;

import jakarta.transaction.Transactional;

@Repository
public interface SignUpRepository extends JpaRepository<SignUpEntity, Integer>{

	public SignUpEntity save(SignUpEntity signUpEntity);

	@Query("from SignUpEntity where userName=:USERNAME")
	public SignUpEntity findEntityByUsername(@Param("USERNAME") String userName);

	@Query("select loginAttempts from SignUpEntity where userName=:USERNAME")
	public int findLoginAttemptsByUsername(@Param("USERNAME") String userName);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update SignUpEntity set loginAttempts=:ATTEMPTS where userName=:USERNAME")
	public void updateLoginAttemptsByUsername(@Param("USERNAME") String userName, @Param("ATTEMPTS") int loginAttempts);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update SignUpEntity set password=:PASSWORD where userName=:USERNAME")
	public void updatePasswordByUsername(@Param("PASSWORD") String password, @Param("USERNAME") String userName);
	
	@Query("select memberCount from SignUpEntity where userName=:USERNAME")
	public int findMemberCountByUserName(@Param("USERNAME") String userName);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update SignUpEntity set memberCount=:COUNT where userName=:USERNAME")
	public void updateMemberCountByUserName(@Param("USERNAME") String userName,@Param("COUNT") int memberCount);


	
}
