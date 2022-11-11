package com.nttdata.service.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.model.Role;
import com.nttdata.model.User;
import com.nttdata.model.UserRole;
import com.nttdata.repository.RoleRepository;
import com.nttdata.repository.UserRepository;
import com.nttdata.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	// Creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		// TODO Auto-generated method stub
		
		
		User local = this.userRepository.findByUsername(user.getUsername());

//		User local = this.userRepository.findByEmail(user.getEmail());
		if (local != null) {
			System.out.println("User is already there !!");
			throw new Exception("User already present!!");
		} 
		else {
			// user create
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
//
		}
		return local;
	}	
//	// getting user by email
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}
//	// delete by user id
	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(userId);
	}

}
