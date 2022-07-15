package com.greatlearning.gradedproject6.erp.service;

import java.util.List;

import com.greatlearning.gradedproject6.erp.entity.Employee;

public interface EmployeeService {
	public List<Employee> listAll();

	public Employee findById(int employeeId);

	public void save(Employee employee);

	public void deleteById(int employeeId);

	public void update(int employeeId, Employee employee);
	
	public List<Employee> findByFName(String firstName);
	
	public List<Employee> sortByFName(String sortOrder);
}
