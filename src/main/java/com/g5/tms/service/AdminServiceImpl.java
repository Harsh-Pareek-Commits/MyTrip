package com.g5.tms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.g5.tms.entities.Admin;

public class AdminServiceImpl extends UserServiceImpl {
	@Autowired

	@Transactional
	public Admin addNewUser(Admin admin) {
		try {
			admin.setUserType("2");
			if ((admin != null)) {
				String securedPasswordHash = BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt(12));
				admin.setPassword(securedPasswordHash);
			}
			userRepository.save(admin);
		} catch (Exception e) {
			log.error("Adding admin exception",e);

		}

		return admin;
	}
	
}