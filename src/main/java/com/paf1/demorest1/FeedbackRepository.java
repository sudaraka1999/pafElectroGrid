package com.paf1.demorest1;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class FeedbackRepository {
	
	
	
	Connection con = null;
	
	public FeedbackRepository()
	{
		String url = "jdbc:mysql://localhost:3306/electrogrid";
	    String username = "root";
	    String password = "";
	    try
	    {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	con = DriverManager.getConnection(url,  username, password);
	    }
	    catch(Exception e) {
	    	System.out.println(e);
	    }
	}
	
	public List<Feedback> getFeedbacks()
	{
		List<Feedback> feedbacks = new ArrayList<>();
		String sql = "select * from feedback";
		try
		{
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())
		{
			Feedback f = new Feedback();
			f.setFid(rs.getInt(1));
			f.setFusername(rs.getString(2));
			f.setFpassword(rs.getString(3));
			f.setFdescription(rs.getString(4));
			
			feedbacks.add(f);
		}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return feedbacks;
	}

	public Feedback getFeedback(int fid)
	{
		
		String sql = "select * from feedback where id=" + fid;
		Feedback f = new Feedback();
		
		try
		{
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(rs.next())
		{
			
			f.setFid(rs.getInt(1));
			f.setFusername(rs.getString(2));
			f.setFpassword(rs.getString(3));
			f.setFdescription(rs.getString(4));
			
			
		}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return f;
		
	}

	public void create(Feedback f1) {
		
		String sql = "insert into feedback values(?,?,?,?)";
		
		try
		{
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, f1.getFid());
		st.setString(2, f1.getFusername());
		st.setString(3, f1.getFpassword());
		st.setString(4, f1.getFdescription());
		st.executeUpdate();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	
public void Update(Feedback f1) {
		
		String sql = "update feedback set username=?, password=?, description=? where id=?";
		
		try
		{
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, f1.getFusername());
		st.setString(2, f1.getFpassword());
		st.setString(3, f1.getFdescription());
		st.setInt(4, f1.getFid());
		st.executeUpdate();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

public void delete(int fid) {
	
	String sql = "delete from feedback where id=?";
	
	try
	{
	PreparedStatement st = con.prepareStatement(sql);
	
	st.setInt(1, fid);
	st.executeUpdate();
	
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
}
	
}
