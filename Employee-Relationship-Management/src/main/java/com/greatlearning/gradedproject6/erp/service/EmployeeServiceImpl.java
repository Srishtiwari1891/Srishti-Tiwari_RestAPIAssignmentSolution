package com.greatlearning.gradedproject6.erp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.gradedproject6.erp.dao.EmployeeRepository;
import com.greatlearning.gradedproject6.erp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> listAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int employeeId) {
		Optional<Employee> result=employeeRepository.findById(employeeId);
		Employee employee = null;
		if(result.isPresent())
			employee=result.get();
		return employee;
	}

	@Override
	public void save(Employee employee) {
			employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}

	@Override
	public void update(int employeeId, Employee employee) {
		Employee updateEmployee = employeeRepository.findById(employeeId)
				.orElseThrow(()-> new IllegalArgumentException("Invalid Employee Id : "+employeeId));
		updateEmployee.setEmployeeId(employeeId);
		updateEmployee.setFirstName(employee.getFirstName());
		updateEmployee.setLastName(employee.getLastName());
		updateEmployee.setEmail(employee.getEmail());
		
		employeeRepository.save(updateEmployee);
		
	}

	@Override
	public List<Employee> findByFName(String firstName) {
		return employeeRepository.findByFirstName(firstName);
	}

	@Override
	public List<Employee> sortByFName(String sortOrder) {
		if(sortOrder.equals("asc")) 
			return employeeRepository.findAllByOrderByFirstNameAsc();
		else if(sortOrder.equals("desc"))
			return employeeRepository.findAllByOrderByFirstNameDesc();
		else
			return employeeRepository.findAll();
	}

}
