package com.paf1.demorest1;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class FeedbackRepository {
	
	
	
	Connection con = null;
	
	public FeedbackRepository()
	{
		con = DriverManager.getConnection(url)
	}
	
	public List<Feedback> getFeedbacks()
	{
		return feedbacks;
	}

	public Feedback getFeedback(int fid)
	{
		
		for(Feedback f:feedbacks)
		{
			if(f.getFid()==fid)
				return f;
		}
		return null;
	}

	public void create(Feedback f1) {
		// TODO Auto-generated method stub
		feedbacks.add(f1);
	}

	
}
