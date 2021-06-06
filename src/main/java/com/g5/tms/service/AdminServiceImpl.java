package com.g5.tms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.g5.tms.entities.Admin;

public class AdminServiceImpl extends UserServiceImpl {
	@Autowired

	@Transactional
	public Admin addNewUser(Admin admin) {
		try {
			admin.setUserType("2");
			userRepository.save(admin);
		} catch (Exception e) {
			log.error("Adding admin exception",e);

		}

		return admin;
	}
	
}