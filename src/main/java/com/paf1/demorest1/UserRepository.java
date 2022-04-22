package com.paf1.demorest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository 
{
	
	
	Connection con = null; 	
	
	
	public UserRepository()
	{
		String url = "jdbc:mysql://localhost:3306/userdb";
		String username = "root";
		String password = "0";
		
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username ,password );
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	public List<User> getUsers()
	{
		List<User> users = new ArrayList<>();
		String sql = "select * from userx";
		
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				User u = new User();
				
				u.setUserID(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPhone(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));
				
				
				users.add(u);
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return users;
	}
	
	
	public User getUser(int id)
	{
		String sql = "select * from userx where id="+id  ;
		User u = new User();
		
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next())
			{
				
				
				u.setUserID(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPhone(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));
				
				
				
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return u;
		
	}



	public void create(User u1) {
		String sql = "insert into userx values(?,?,?,?,?)";
		
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1,u1.getUserID());
			st.setString(2, u1.getName());
			st.setString(3, u1.getPhone());
			st.setString(4, u1.getEmail());
			st.setString(5, u1.getPassword());
			
			st.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
	
	
}














