package com.paf1.demorest1;

import java.util.ArrayList;
import java.util.List;

public class UserRepository 
{
	List<User> users;
	
	public UserRepository()
	{
		users = new ArrayList<>();
		 
		User u1 = new User();
		u1.setUserID(1);
		u1.setName("Ashan");
		u1.setPhone("0765689654");
		u1.setEmail("ashan@gmail.com");
		u1.setPassword("a123");
		
		
		User u2 = new User();
		u2.setUserID(2);
		u2.setName("Bimal");
		u2.setPhone("0765563254");
		u2.setEmail("bimal@gmail.com");
		u2.setPassword("b123"); 
		
		 users.add(u1);
		 users.add(u2);
	}
	
	
	
	public List<User> getUsers()
	{
		return users;
	}
	
	
	public User getUser(int id)
	{
				
		
		for(User u : users)
		{
			if(u.getUserID()==id)
			{
				return u;
			}
		}
		
		return null;
	}



	public void create(User u1) {
		// TODO Auto-generated method stub
		users.add(u1);
	
	}
	
	
}














