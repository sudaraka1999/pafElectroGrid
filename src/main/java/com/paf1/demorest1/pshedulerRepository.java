package com.paf1.demorest1;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class pshedulerRepository {
Connection con = null;
	
	public pshedulerRepository() {
		String url = "jdbc:mysql://localhost:3308/electrogrid";
		String username = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public List<psheduler> getPshedulers(){
		List<psheduler> pshedulers = new ArrayList<>();
		String sql = "select * from pshedule";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				psheduler p = new psheduler();
				p.setpLid(rs.getInt(1));
				p.setpLocation(rs.getString(2));
				p.setpDuration(rs.getString(3));
				p.setpReason(rs.getString(4));
				p.setpDescription(rs.getString(5));
				
				pshedulers.add(p);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return pshedulers;
		
	}
	public psheduler getPsheduler(int id) {
		List<psheduler> pshedulers = new ArrayList<>();
		String sql = "select * from pshedule where id="+id;
		psheduler p = new psheduler();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				p.setpLid(rs.getInt(1));
				p.setpLocation(rs.getString(2));
				p.setpDuration(rs.getString(3));
				p.setpReason(rs.getString(4));
				p.setpDescription(rs.getString(5));
				
				pshedulers.add(p);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return p;
	
	}
	public void create(psheduler p1) {
		String sql = "insert into pshedule values(?,?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, p1.getpLid());
			st.setString(2,p1.getpLocation());
			st.setString(4, p1.getpReason());
			st.setString(5, p1.getpDescription());
			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	

}
