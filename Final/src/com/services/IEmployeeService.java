package com.services;

import com.models.Employee;

public interface IEmployeeService {
	
		Employee getEmployeeById(long id);
		long addEmployee(Employee employee);
		boolean deleteEmployee(long id);
		long updateEmployee(String name,int age,String address, long id);
		
	}
	


