package com.g5.tms.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.g5.tms.entities.Admin;

import com.g5.tms.exceptions.InvalidCredentialException;

public class AdminServiceImpl extends UserServiceImpl {

	@Transactional
	public Admin addNewUser(Admin admin) {
		try {
			admin.setUserType("2");
			user_repo.save(admin);
		} catch (Exception e) {
			e.getStackTrace();

		}

		return admin;
	}
	
}