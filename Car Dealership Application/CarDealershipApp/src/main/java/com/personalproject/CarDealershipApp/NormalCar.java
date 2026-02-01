package com.personalproject.CarDealershipApp;

public class NormalCar implements Car{
	
	String owner;
	Tyre tyre;
	
	public NormalCar(Tyre tyre) {
		this.tyre=tyre;
	}
	
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "Family Car"+tyre.getTyreInfo();
	}

	@Override
	public void setOwnerName(String name) {
		// TODO Auto-generated method stub
		this.owner=name;
	}

	@Override
	public String getOwnerName() {
		// TODO Auto-generated method stub
		
		return this.owner;
	}
}
