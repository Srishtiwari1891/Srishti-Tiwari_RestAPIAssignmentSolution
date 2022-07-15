package com.greatlearning.gradedproject6.erp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.gradedproject6.erp.entity.User;
import com.greatlearning.gradedproject6.erp.service.UserService;

@RestController
@RequestMapping("api")
public class UserRestController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public User addUser(User user) {
		user.setUserId(0);
		userService.addUser(user);
		return user;
	}

	@GetMapping("/users")
	public List<User> getUser() {
		return userService.listUser();
	}
}
