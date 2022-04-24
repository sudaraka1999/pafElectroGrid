package com.paf1.demorest1;

import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
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
	public Feedback createFeedback(Feedback f1)
	{
		System.out.println(f1);
		repo.create(f1);
		
		return f1;
	}
}
