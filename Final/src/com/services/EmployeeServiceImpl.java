package com.services;

import dao.*;
import com.models.*;

public class EmployeeServiceImpl implements IEmployeeService  {

	//private List<Employee> empList=new ArrayList<Employee>();
	
	
	private DAO empDao = new DAO();
	private long Counter = empDao.getEmployeeId();
	

	public long addEmployee(Employee employee)
	{
		employee.setId(++Counter);
		return empDao.addEmployee(employee);
		
	}
	
	
	public Employee getEmployeeById(long id)
	{
		return getEmployeeById(id);
	}
	
	public boolean deleteEmployee(long id)
	{
		
		boolean res = empDao.deleteEmployee(id);
		return res;
	}
	
	public long updateEmployee(String name,int age,String address, long id)
	{
		boolean res = empDao.updateEmployee(name,age,address,id);
		if(res)
		{
			return id;
		}
		else 
		{
			return 0;
		}
	}
	
	
}
	