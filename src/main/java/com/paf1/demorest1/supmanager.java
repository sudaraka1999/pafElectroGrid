package com.paf1.demorest1;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class supmanager {
	 private int supID;
	 private String supname;
	 private String supdiscription;
	 private String suppassword;
	
	 
	public int getSupID() {
		return supID;
	}


	public void setSupID(int supID) {
		this.supID = supID;
	}


	public String getSupname() {
		return supname;
	}


	public void setSupname(String supname) {
		this.supname = supname;
	}


	public String getSupdiscription() {
		return supdiscription;
	}


	public void setSupdiscription(String supdiscription) {
		this.supdiscription = supdiscription;
	}


	public String getSuppassword() {
		return suppassword;
	}


	public void setSuppassword(String suppassword) {
		this.suppassword = suppassword;
	}


	@Override
	public String toString() {
		return "supmanager [supID=" + supID + ", supname=" + supname + ", supdiscription=" + supdiscription
				+ ", suppassword=" + suppassword + "]";
	}


	
	 
	 

	 
	 

}
