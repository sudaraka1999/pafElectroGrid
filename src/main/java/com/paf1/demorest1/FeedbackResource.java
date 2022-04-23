package com.paf1.demorest1;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("feedbacks")
public class FeedbackResource {

	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Feedback getFeedback()
	{
		
		System.out.println("getFeedback...");
		Feedback f1 = new Feedback();
		f1.setFid(001);
		f1.setFusername("pethmi");
		f1.setFpassword("pethmi123");
		f1.setFdescription("good");
		
		return f1;
	}
}
