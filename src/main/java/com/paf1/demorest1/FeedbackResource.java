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

@Path("feedbacks")
public class FeedbackResource {

	FeedbackRepository repo = new FeedbackRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Feedback> getFeedbacks()
	{
		System.out.println("getFeedback...");
		return repo.getFeedbacks();
	}
	

	@GET
	@Path("feedback/{fid}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Feedback getFeedback(@PathParam("fid") int fid)
	{
		return repo.getFeedback(fid);
	}
	
	@POST
	@Path("feedback")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Feedback createFeedback(Feedback f1)
	{
		System.out.println(f1);
		repo.create(f1);
		
		return f1;
	}
	
	@PUT
	@Path("feedback")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Feedback updateFeedback(Feedback f1)
	{
		System.out.println(f1);
		if(repo.getFeedback(f1.getFid()).getFid()==0)
		{
		 repo.create(f1);
		}
		else
		{
		 repo.Update(f1);
		}
		return f1;
	}
	
	@DELETE
	@Path("feedback/{fid}")
	public Feedback killFeedback(@PathParam("fid") int fid)
	{
		Feedback f = repo.getFeedback(fid);
		
		if(f.getFid()!=0)
		repo.delete(fid);
		
		return f;
	}
	
}
