package com.g5.tms.service;

import javax.transaction.Transactional;



import com.g5.tms.entities.Admin;


public class AdminServiceImpl extends UserServiceImpl {

	@Transactional
	public Admin addNewUser(Admin admin) {
		try {
			admin.setUserType("2");
			userRepository.save(admin);
		} catch (Exception e) {
			e.getStackTrace();

		}

		return admin;
	}
	
}