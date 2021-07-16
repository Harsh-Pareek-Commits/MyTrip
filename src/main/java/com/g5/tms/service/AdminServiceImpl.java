package com.g5.tms.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.g5.tms.entities.Admin;
import com.g5.tms.entities.User;

public class AdminServiceImpl extends UserServiceImpl {
	@Autowired

	@Transactional
	public Admin addNewUser(Admin admin) throws Exception {
		try {
			admin.setUserType("2");
			if ((admin.getPassword() != null)) {
				String securedPasswordHash = BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt(12));
				admin.setPassword(securedPasswordHash);
			}
			Optional<User> opt =userRepository.findByEmail(admin.getEmail());
			if(opt.isPresent())
			{
				throw new Exception("Please ann unique email id");
			}
			userRepository.save(admin);
		} catch (Exception e) {
			log.error("Adding admin exception",e);

		}

		return admin;
	}
	
}