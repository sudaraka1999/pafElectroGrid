package com.paf1.demorest1;



import java.util.Arrays;
import java.util.List;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
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
   
	@GET
	@Path("supmanager/{supID}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  public supmanager getsupmanager(@PathParam("supID")int supID)
  {
	  return repo.getsupmanager(supID);
  }
   
   
   
   @POST
   @Path("supmanager")
   public supmanager createsupmanager(supmanager s1)
   {
	   System.out.println(s1);
	   repo.create(s1);
	   return s1;
   }
}
