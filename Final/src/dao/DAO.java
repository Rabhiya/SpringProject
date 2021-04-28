package dao;

import java.sql.*;
import connection.*;
import com.models.Employee;
//import java.util.*;

public class DAO {
	private static ConnectionUtility conUtil = new ConnectionUtility();
	private static Connection con = conUtil.getConnect();
	
	public long addEmployee(Employee emp)
	{
		try 
		{
			PreparedStatement stmt = con.prepareStatement("insert into emp values(?,?,?,?)");
			stmt.setLong(1, emp.getId());
			stmt.setString(2, emp.getName());
			stmt.setInt(3, emp.getAge());
			stmt.setString(4, emp.getAddress());
			
			int res = stmt.executeUpdate();
			if(res!=0)
			{
				return emp.getId();
			}
		} 
		catch (SQLException e)
		{
			System.out.println("Can not insert details");
			e.printStackTrace();
		}
		return 0;
	}
	
	public Employee getEmployeeById(long id)
	{
		Employee emp = null;

		try {
			PreparedStatement stmt = con.prepareStatement("select * from emp where id=?");
			stmt.setLong(1, id);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				emp = Employee.createEmployeeDetails(res.getLong(1), res.getNString(2), res.getInt(3),
						res.getString(4));
			}
			return emp;

		}
		catch (SQLException e)
		{
			System.out.println("Something wrong in display");
		}
		return null;
	}
	
	public boolean deleteEmployee(long id)
	{
		try 
		{
			PreparedStatement stmt = con.prepareStatement("delete from emp where id=?");
			stmt.setLong(1, id);
			int res = stmt.executeUpdate();
			if(res!=0)
			{
				return true;
			}
		} 
		catch (SQLException e)
		{
			System.out.println("Something went wrong on deletion");
		}
		return false;
	}
	
	public boolean updateEmployee(String name,int age, String address, long id)
	{
		try 
		{
			PreparedStatement stmt = con.prepareStatement("update emp set name=?,age=?,address=? where id=?");
			stmt.setString(1, name);
			stmt.setInt(2, age);
			stmt.setString(3, address);
			stmt.setLong(4, id);
			int res = stmt.executeUpdate();
			if(res!=0)
			{
				return true;
			}
		}
		catch (SQLException e) 
		{
			System.out.println("Something went wrong on updation");
		}
		return false;
	}
	
	public long getEmployeeId()
	{
		long id = 0;
		try 
		{
			
			PreparedStatement stmt = con.prepareStatement("select er.id  from(select id,Row_Number()over (order by id)'rownum' from emp) er where rownum <=1 order by id desc");
			ResultSet res = stmt.executeQuery();
			while(res.next())
			{
				id = res.getLong(1);
			}
			return id;
		} 
		catch (SQLException e)
		{
			System.out.println("Something went wrong in id");
			e.printStackTrace();
		}
		return 0;
	}
	
	

}
