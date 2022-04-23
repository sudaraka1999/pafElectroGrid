package com.paf1.demorest1;

import java.util.Arrays;
import java.util.List;

import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("users")
public class UserResource 
{
	
	UserRepository repo =  new UserRepository();
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUsers()
	{
		System.out.println("getUser called");
		return repo.getUsers();  
	}
	
	
	
//	@GET
//	@Path("user/{id}")
//	@Produces(MediaType.APPLICATION_XML)
//	public User getUser(@PathParam("id") int id)
//	{
//		
//		return repo.getUser(id);  
//	}
//	
	
	
 	
	@POST
	@Path("user")
	public User createUser(User u1)
	{
		System.out.println(u1);
		repo.create(u1);
		
		return u1; 
	}
	
	
}
















