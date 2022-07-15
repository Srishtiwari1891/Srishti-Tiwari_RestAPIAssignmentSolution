package com.greatlearning.gradedproject6.erp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.gradedproject6.erp.entity.Role;
import com.greatlearning.gradedproject6.erp.service.RoleService;

@RestController
@RequestMapping("api")
public class RoleRestController {

	@Autowired
	private RoleService roleService;
	
	@PostMapping("roles")
	public Role addRole(@RequestBody Role role) {
		role.setRoleId(0);
		roleService.addRole(role);
		return role;
	}
	
	@GetMapping("roles")
	public List<Role> getRole(){
		return roleService.listRole();
	}
}
