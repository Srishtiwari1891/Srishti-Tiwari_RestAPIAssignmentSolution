package com.greatlearning.gradedproject6.erp.service;

import java.util.List;

import com.greatlearning.gradedproject6.erp.entity.User;

public interface UserService {
	public void addUser(User user);
	public List<User> listUser();
}
