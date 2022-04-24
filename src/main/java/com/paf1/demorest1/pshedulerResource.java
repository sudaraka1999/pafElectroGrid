package com.paf1.demorest1;
import java.util.List;
//import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.PathParam;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("pshedulers")
public class pshedulerResource {

pshedulerRepository repo = new pshedulerRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<psheduler> getpshedular()
	{
	
		
			return repo.getPshedulers();
		
	}
	
	@GET
	@Path("psheduler/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public psheduler getpshedula(@PathParam("id")int id){
		return repo.getPsheduler(id);
	}
	@POST
	@Path("psheduler")
	public psheduler createpsheduler(psheduler p1) {
		System.out.println(p1);
		repo.create(p1);
		return p1;
	}
}
