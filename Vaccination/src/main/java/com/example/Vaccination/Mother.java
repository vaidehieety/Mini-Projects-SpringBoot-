package com.example.Vaccination;

import com.example.Vaccination.User;

/**
  This class is an implementation of a User Interface based on the selection 
  in the console the user type is selected.You need to complete this class 
  based on the following tasks.
    
   Tasks:
 a.Override the methods of User Interface.
 b.Adding common attributes:
    1. String name
    2. Integer age
    3. boolean isVaccinated
    4. TimeAndLocation(class), vaccine(interface), both are injected by the constructor method.
    5. The arguments of the constructor for all users should be like "public User(TimeAndLocation timeAndLocation, Vaccine vaccine)"
 c.Build the logic for all the methods based on the description mentioned in the User Interface.
 
**/
public class Mother implements User {
	public String name;
	public int age;
	public boolean isVaccinated;
	TimeAndLocation timeAndLocation;
	Vaccine vaccine;
	public Mother() {
		
	}
	public void setVaccine(Vaccine vaccine) {
		this.vaccine=vaccine;
	}
	
	public Vaccine getVaccineDetails() {
		return this.vaccine;
	}
	
	public void setUserDetails(String name, int age, TimeAndLocation timeAndLocation) {
		this.name=name;
		this.age=age;
		this.timeAndLocation=timeAndLocation;
	}
	
	public void setAppointment() {
		System.out.println("Hello "+this.name+" your appointment has been fixed for "+this.vaccine+" Vaccine on "+this.timeAndLocation);
		this.isVaccinated=true;
	}

	public boolean IsVaccinated() {
		return this.isVaccinated;
	}
}