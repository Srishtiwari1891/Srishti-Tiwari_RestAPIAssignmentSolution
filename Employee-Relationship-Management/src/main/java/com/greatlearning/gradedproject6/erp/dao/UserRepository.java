package com.greatlearning.gradedproject6.erp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.gradedproject6.erp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUsername(String username);
}
