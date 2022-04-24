package com.mereesha.ElectroGrid;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class BillRepository {
	
Connection con= null;
	
	public BillRepository() {
		
	String url = "jdbc:mysql://localhost:3306/electrogridbill";
	String username = "root";
	String password = "Mereen0308*";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password);
	}
	catch(Exception e){
		System.out.println(e);
	}
		
	}
	
	public List<Bill> getBills(){
		List<Bill> bills = new ArrayList<>();
		String sql = "select * from bill";
		try {
			Statement st= con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			System.out.println("List of bills");
			while(rs.next())
			{
				Bill a=new Bill();
				a.setId(rs.getInt(1));
				a.setCusId(rs.getString(2));
				a.setAddress(rs.getString(3));
				a.setUnit(rs.getInt(4));
				a.setYear(rs.getInt(5));
				a.setMonth(rs.getString(6));
				a.setTotalNew();
				
				
				bills.add(a);
			}
			}
		catch(Exception e) {
			System.out.println(e);
		}
		return bills;
	}
	
	public Bill getBill(int id) {
		String sql = "select * from bill where id="+id; 
		Bill a=new Bill();
		try {
			Statement st= con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				
				a.setId(rs.getInt(1));
				a.setCusId(rs.getString(2));
				a.setAddress(rs.getString(3));
				a.setUnit(rs.getInt(4));
				a.setYear(rs.getInt(5));
				a.setMonth(rs.getString(6));
				a.setTotalNew();
				
			}
			}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return a;
	}

	public void create(Bill a1) {
		String sql = "insert into bill values(?,?,?,?,?,?,?)";
		
		
		
		try {
			PreparedStatement st= con.prepareStatement(sql);
			st.setInt(1, a1.getId());
			st.setString(2,a1.getCusId());
			st.setString(3,a1.getAddress());
			st.setInt(4,a1.getUnit());
			st.setInt(5, a1.getYear());
			st.setString(6,a1.getMonth());
			
			st.setInt(7,a1.getTotal());
			st.executeUpdate();
			System.out.println("Create successfully");
			
			}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void update(Bill a1) {
		String sql = "update bill set cusId=?, address=?, unit=?, year=?, month=? where id=? ";
		
		try {
			PreparedStatement st= con.prepareStatement(sql);
			
			st.setString(1, a1.getCusId());
			st.setString(2, a1.getAddress());
			st.setInt(3, a1.getUnit());
			
			st.setInt(4, a1.getYear());
			st.setString(5,a1.getMonth());
			
			
			st.setInt(6, a1.getId());
			st.executeUpdate();
			System.out.println("Updated!");
			}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
	String sql = "delete from bill  where id=? ";
	
		
		try {
			PreparedStatement st= con.prepareStatement(sql);
		
			st.setInt(1,id);
			st.executeUpdate();
			System.out.println("Deleted!");
			}
		catch(Exception e) {
			System.out.println(e);
		}
	}
		
	}


