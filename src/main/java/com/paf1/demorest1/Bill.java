package com.mereesha.ElectroGrid;


import jakarta.xml.bind.annotation.*;

@XmlRootElement

public class Bill {
	private int Id;
	private String cusId;
	private String address;
	private int unit;
	private int year;
	private String month;
	private int total;
	
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getCusId() {
		return cusId;
	}
	public void setCusId(String cusId) {
		this.cusId = cusId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
			this.address = address;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getTotal() {
		return total;
	}
	
//	*************************************************************************************************************
	public void setTotalNew() {
     int x= this.getUnit();
     
     if(x<60) {
    	 this.total=(x*10);
     }
     
     else if(x<90) {
    	 this.total= (60*10)+((x-60)*20);
     }
     
     else if(x<120) {
    	 this.total= (60*10)+(30*20)+((x-90)*30);
     }
     
     else if(x<180){
    	 this.total= (60*10)+(30*20)+(30*30)+((x-120)*35);
     }
     
     else if(x<350){
    	 this.total= (60*10)+(30*20)+(30*30)+(60*35)+((x-180)*45);
     }

     else {
    	 this.total= (60*10)+(30*20)+(30*30)+(60*35)+(170*45)+((x-350)*100);
     }
     
	}
	
	
	//*********************************************************************************
	
	@Override
	public String toString() {
		return "Bill [Id=" + Id + ", cusId=" + cusId + ", address=" + address + ", unit=" + unit + ", total=" + total
				+ ", month=" + month + ", year=" + year + "]";
	}
	
	
	
	
}
