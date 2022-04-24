package com.paf1.demorest1;



import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("supmanagers")
public class SupmanagerResource 
{
	SupmanagerRepository repo = new SupmanagerRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   public List<supmanager> getsupmanagers()
   {
	   System.out.println("getsupmanager called...");
	   return repo.getsupmanagers();
   }
   
   //retrive data
   
	@GET
	@Path("supmanager/{supID}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  public supmanager getsupmanager(@PathParam("supID")int supID)
  {
	  return repo.getsupmanager(supID);
  }
   
   //create data
   
   @POST
   @Path("supmanager")
   @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   public supmanager createsupmanager(supmanager s1)
   {
	   System.out.println(s1);
	   repo.create(s1);
	   return s1;
   }
   
   
   //update data
   
   @PUT
   @Path("supmanager")
   @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   public supmanager updatesupmanager(supmanager s1)
   {
	   System.out.println(s1);
	   
	   if(repo.getsupmanager(s1.getSupID()).getSupID()==0)
	   {
		   repo.create(s1);
	   }
	   else {
	   repo.update(s1);
	   
	   }
	return s1;
	
   }
   
	@DELETE
	@Path("supmanager/{supID}")
	public supmanager killsupmanager(@PathParam("supID")int supID)
	
	{
		supmanager s = repo.getsupmanager(supID);
		
		if(s.getSupID()!=0)
			repo.delete(supID);
		
		return s;
	}
   }

