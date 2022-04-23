package com.paf1.demorest1;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Feedback {
	
	private int fid;
	private String fusername;
	private String fpassword;
	private String fdescription;  
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}  
	public String getFusername() {
		return fusername;
	}
	public void setFusername(String fusername) {
		this.fusername = fusername;
	}
	public String getFpassword() {
		return fpassword;
	}
	public void setFpassword(String fpassword) {
		this.fpassword = fpassword;
	}
	public String getFdescription() {
		return fdescription;
	}
	public void setFdescription(String fdescription) {
		this.fdescription = fdescription;
	}
	
	
	

}
