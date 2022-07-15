package com.greatlearning.gradedproject6.erp.service;

import java.util.List;

import com.greatlearning.gradedproject6.erp.entity.Role;

public interface RoleService {
	public void addRole(Role role);
	public List<Role> listRole();
}
