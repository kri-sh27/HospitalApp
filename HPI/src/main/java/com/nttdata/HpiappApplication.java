package com.nttdata;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.model.Role;
import com.nttdata.model.User;
import com.nttdata.model.UserRole;
import com.nttdata.repository.RoleRepository;
import com.nttdata.service.UserService;

@SpringBootApplication
public class HpiappApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;
   
	@Autowired
	private RoleRepository roleRepository;
	public static void main(String[] args) {
		SpringApplication.run(HpiappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Starting code");
////		
//		User user = new User();
////		
//		user.setUsername("user1");
//		user.setFullName("Krishnat R Hogale");//Deepak
//		user.setEmail("krishnat@gmail.com");//deepak@gmail.com
//		user.setPassword("abc");
////		
//		Role role1=new Role();
//		role1.setRoleId(44L);//46
//		role1.setRoleName("ADMIN");//Doctor
////		
//		Set<UserRole> userRoleSet=new HashSet<>();
//		UserRole userRole=new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
////		
//		userRoleSet.add(userRole);
////		//
//				User user1= this.userService.createUser(user, userRoleSet);
//				System.out.println(user1.getFullName());
	}

}
