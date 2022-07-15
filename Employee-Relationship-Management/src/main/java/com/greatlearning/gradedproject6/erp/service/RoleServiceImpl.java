package com.greatlearning.gradedproject6.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.gradedproject6.erp.dao.RoleRepository;
import com.greatlearning.gradedproject6.erp.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public void addRole(Role role) {
		roleRepository.save(role);
	}

	@Override
	public List<Role> listRole() {
		return roleRepository.findAll();
	}

}
