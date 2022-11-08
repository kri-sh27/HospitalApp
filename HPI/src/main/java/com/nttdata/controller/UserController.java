package com.nttdata.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.model.Role;
import com.nttdata.model.User;
import com.nttdata.model.UserRole;
import com.nttdata.service.UserService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

	@Autowired
	UserService userService;

//	creating user with role => normal && one Admin role
	@PostMapping("/createuser")
	public User createUser(@RequestBody User user) throws Exception {

		System.out.println(user);
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole> roles = new HashSet<>();

		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");

		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);

		roles.add(userRole);

		return this.userService.createUser(user, roles);
	}

	// get Api Fot getting user by Gmail
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}

	// delete the user by id
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long uerId) {
		this.userService.deleteUser(uerId);
	}

}
