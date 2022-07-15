package com.greatlearning.gradedproject6.erp.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.gradedproject6.erp.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByFirstName(String firstName);
	List<Employee> findAllByOrderByFirstNameAsc();
	List<Employee> findAllByOrderByFirstNameDesc();
}