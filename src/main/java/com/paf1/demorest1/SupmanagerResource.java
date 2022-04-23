package com.paf1.demorest1;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("supmanagers")
public class SupmanagerResource 
{
	
	@GET
   public supmanager getsupmanager()
   {
	   System.out.println("getsupmanager called...");
	   supmanager s1 = new supmanager();
	   s1.setSupgrID("S18646");
	   s1.setSupname("Vishal");
	   s1.setSupdiscription("100 units provided ");
	   s1.setSuppassword("sup12378");
	   
	   return s1;
   }
}
