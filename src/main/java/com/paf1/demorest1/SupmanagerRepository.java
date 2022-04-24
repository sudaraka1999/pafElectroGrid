package com.paf1.demorest1;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class SupmanagerRepository 
{
	
	Connection con= null;
 
	public SupmanagerRepository ()
	{
		String url ="jdbc:mysql://localhost:3306/electogrid";
		String username = "root";
		String password = "";
		
		try
		{
		   Class.forName("com.mysql.jdbc.Driver");
		   con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public List<supmanager> getsupmanagers()
	{
		
		List<supmanager> supmanagers = new ArrayList<>();
		
		String sql ="select * from suppliermanagement";
		try
		{
		Statement st= con.createStatement();
		ResultSet rs =st.executeQuery(sql);
		
		while(rs.next())
		{
			supmanager s = new supmanager();
			s.setSupID(rs.getInt(1));
			s.setSupname(rs.getString(2));
			s.setSupdiscription(rs.getString(3));
			s.setSuppassword(rs.getString(4));
			
			supmanagers.add(s);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return supmanagers;
	}
	 public supmanager getsupmanager(int supID)
	 {
		 String sql ="select * from suppliermanagement where id="+supID;
		 supmanager s = new supmanager();
			try
			{
			Statement st= con.createStatement();
			ResultSet rs =st.executeQuery(sql);
			if(rs.next())
			{
			
				s.setSupID(rs.getInt(1));
				s.setSupname(rs.getString(2));
				s.setSupdiscription(rs.getString(3));
				s.setSuppassword(rs.getString(4));
				
				
			}
			}
			
			catch(Exception e)
			{
				System.out.println(e);
			}
			return s;
		 
		
	 }

	public void create(supmanager s1) {
		
		String sql= "insert into suppliermanagement values(?,?,?,?)";
		try
		{
		PreparedStatement st= con.prepareStatement(sql);
         st.setInt(1,s1.getSupID() );
         st.setString(2,s1.getSupname());
         st.setString(3,s1.getSupdiscription());
         st.setString(4, s1.getSuppassword());
         st.executeUpdate();
		
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
public void update(supmanager s1) {
		
        String sql= "update suppliermanagement set name=?,discription=?,password=? where id=?";
		try
		{
		PreparedStatement st= con.prepareStatement(sql);
         st.setInt(4,s1.getSupID());
         st.setString(1,s1.getSupname());
         st.setString(2,s1.getSupdiscription());
         st.setString(3, s1.getSuppassword());
         st.executeUpdate();
		
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

public void delete(int supID) {
	
	String sql= " delete from suppliermanagement where id=? ";
	try
	{
	PreparedStatement st= con.prepareStatement(sql);
     st.setInt(1,supID);
    
     st.executeUpdate();
	
	}
	
	catch(Exception e)
	{
		System.out.println(e);
	}
	
}
	
}
