package com.paf1.demorest1;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class SupmanagerRepository 
{
	List<supmanager>supmanagers ;
	
	Connection con= null;
 
	public SupmanagerRepository ()
	{
		supmanagers = new ArrayList<>();
		   
		   supmanager s1 = new supmanager();
		   s1.setSupID(18646);
		   s1.setSupname("Vishal");
		   s1.setSupdiscription("100 units provided ");
		   s1.setSuppassword("sup12378");
		   
		   supmanager s2 = new supmanager();
		   s2.setSupID(78564);
		   s2.setSupname("Naduni");
		   s2.setSupdiscription("New supplier's reports generated" );
		   s2.setSuppassword("sup90906");
		   
		   supmanagers.add(s1);
		   supmanagers.add(s2);
	}
	
	public List<supmanager> getsupmanagers()
	{
		return supmanagers;
	}
	 public supmanager getsupmanager(int supID)
	 {
		 
		 for(supmanager s: supmanagers)
		 
		 {
			 if(s.getSupID()==supID)
				 return s;
		 }
		 
		return null;
	 }

	public void create(supmanager s1) {
		// TODO Auto-generated method stub
		supmanagers.add(s1);
	}
	
	
}
