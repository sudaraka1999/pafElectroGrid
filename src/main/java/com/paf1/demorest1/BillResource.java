package com.mereesha.ElectroGrid;

import java.util.Arrays;

import java.util.List;



import jakarta.ws.rs.GET;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;


@Path("bills")
public class BillResource {
	
	BillRepository repo = new BillRepository();
	 
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Bill> getBills()
	{
		System.out.println("getBill called...");
		return repo.getBills();
	}
	
	
	@GET
	@Path("bill/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Bill getBill(@PathParam("id")int id) {
		System.out.println("**********");
		return repo.getBill(id);
	}
	
	@POST
	@Path("bill")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Bill createBill(Bill a1) {
		System.out.println(a1);
		System.out.println("Created successfully");
		
		repo.create(a1);
		
		return a1;
		
	}
	
	
	@PUT
	@Path("bill")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Bill updateBill(Bill a1) {
		System.out.println(a1);
		if(repo.getBill(a1.getId()).getId()==0) {
			repo.create(a1);
			System.out.println("Created successfully");
		}
		
		else {
			repo.update(a1);
			System.out.println("Update successfully");
		}
		
		return a1;
		
	}
	
	
	@DELETE
	@Path("bill/{id}")
	public Bill killBill(@PathParam("id") int id) {
		Bill a = repo.getBill(id);
		
		if(a.getId()!=0) 
		
			repo.delete(id);
		
		System.out.println("Deleted successfully");
		
		return a;
	}
	
}



