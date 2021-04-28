package controller;

import java.util.Scanner;
//import connection.*;

import com.models.Employee;
import com.services.EmployeeServiceImpl;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement; 
//import java.sql.*;


public class EmployeeController {
	private Scanner sc = new Scanner(System.in);
	
	private EmployeeServiceImpl services;
	

	    public void handleRequest() {
		boolean back = false;
		displayMenu();
		System.out.print("\t\t\t Welcome to the Employee registration system\n");
		while (!back) {
			//System.out.print("\t\t\t Welcome to the Employee registration system\n");

			String choice = sc.nextLine();
			try {
				int Choice = Integer.parseInt(choice);
				switch (Choice) {
				case 0:
					System.out.println("Employee registration system closed");
					back = true;
					break;
				case 1:
				    addEmployee();
	        		//System.out.println("Added Employee Generated ID: " +addId);
	        		System.out.println();
					break;
				case 2:
					displayEmployeeById();
					break;
					
				case 3:
					updateEmployee();
					break;

				case 4:
					deleteEmployee();
					break;

				case 6:
					displayMenu();
					break;
				
					default:
						System.out.println("Press the right key.\n OR Type 6 to display the menu");
				}

			} catch (Exception e) {
				System.out.println("Something went wrong type 6 to try again");
				e.printStackTrace();
			}
		}

	}

	public long addEmployee() {
		try {
			System.out.print("\nEnter Employee Name :- ");
			String empName = sc.nextLine();
			System.out.print("Enter Employee Age :- ");
			int empAge = sc.nextInt();
			System.out.print("Enter Employee Address :- ");
			String empAddress = sc.nextLine();
			System.out.println("Data inserted successfully");
			Employee newEmployee = Employee.createEmployeeDetails(0, empName, empAge, empAddress);
			long id = services.addEmployee(newEmployee);
			System.out.print("Genarated ID " + id);
			

		} catch (Exception e) {
			System.out.println("Something wrong in addition process");
			e.printStackTrace();
		}
		return 0;

	}
	public Employee displayEmployeeById()
	{
		try
		{
			
			System.out.print("\nEnter the Employee ID :- ");
			String empId = sc.nextLine();
			return services.getEmployeeById(Long.parseLong(empId));
		}
		catch(Exception e)
		{
			System.out.println("SOmething went wrong");
			//e.printStackTrace();
		}
		return null;	
	}

	public boolean deleteEmployee()
	{
		try
		{
			System.out.print("\nEnter the Employee ID :- ");
			String empId = sc.nextLine();
			return services.deleteEmployee(Long.parseLong(empId));
		}
		catch(Exception ex)
		{
			System.out.println("Something went wrong");
			//ex.printStackTrace();
		}
		return false;
	}
	
	public void updateEmployee()
	{
		System.out.print("\nEnter the Employee Id to Update :- ");
		long id = sc.nextLong();
		System.out.print("\nEnter updated name :- ");
		String name = sc.nextLine();
		System.out.print("\nEnter updated age :- ");
		int age = sc.nextInt();
		System.out.print("\nEnter updated address :- ");
		String address = sc.nextLine();
		long updatedId=services.updateEmployee(name,age,address,id);
		if(updatedId!=0)
		{
			System.out.println("Employee name updated for "+updatedId);
		}
		else
		{
			System.out.println("Employee not present");
		}
		
	}
	public void displayMenu() {
		System.out.println("Type here:" + "\nType 0 to close\n" + "Type 1 to Add Employee\n"+ "Type 2 to Display Employee details\n" + "Type 3 to Update Employee details\n"+ "Type 4 to Remove Employee details\n" + "Type 5 to Search Employee details \n");
	}

		
}
