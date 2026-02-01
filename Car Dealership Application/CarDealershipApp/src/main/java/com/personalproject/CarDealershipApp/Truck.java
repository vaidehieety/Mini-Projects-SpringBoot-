package com.personalproject.CarDealershipApp;

public class Truck  implements Car{
	String owner;
	Tyre tyre;
	
	public Truck(Tyre tyre) {
		this.tyre=tyre;
	}
	
	public String getInfo() {
		// TODO Auto-generated method stub
		return "Truck"+tyre.getTyreInfo();
	}


	public void setOwnerName(String name) {
		// TODO Auto-generated method stub
		this.owner=name;
	}

	public String getOwnerName() {
		// TODO Auto-generated method stub
		return this.owner;
	}

}
