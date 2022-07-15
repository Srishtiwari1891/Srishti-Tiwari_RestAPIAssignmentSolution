package com.greatlearning.gradedproject6.erp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.gradedproject6.erp.entity.Employee;
import com.greatlearning.gradedproject6.erp.service.EmployeeService;

@RestController
@RequestMapping("api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAllEmployee(){
		return employeeService.listAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setEmployeeId(0);
		employeeService.save(employee);
		return employee;
	}	
	
	@PutMapping("/employees/{employeeId}")
	public Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee employee) {
		employeeService.update(employeeId,employee);
		return employee;
	}
	
	@GetMapping("/employees/search")
	public List<Employee> getEmployeeByFirstName(@RequestParam(required = false) String fname) {
		return employeeService.findByFName(fname);
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if(employee==null)
			throw new RuntimeException("Employee ID "+ employeeId+" not found");
		employeeService.deleteById(employeeId);
		return "Deleted Employee ID: "+employeeId;  
	}
	
	@GetMapping("/employees/sort")
	public List<Employee> sortEmployeeList(@RequestParam(required = false) String sorder){
		return employeeService.sortByFName(sorder);
	}
}
