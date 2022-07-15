package com.greatlearning.gradedproject6.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.gradedproject6.erp.dao.UserRepository;
import com.greatlearning.gradedproject6.erp.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> listUser() {
		return userRepository.findAll();
	}

}
