package com.example.Cinemaxify;

// Override the User Interface methods in Spouse class
public class Spouse implements User {

    private String name;
    private final String memberName = "spouse";
    private int age;
    private Long contact;
    private String address;
    private Plan plan;
    
    
    public Spouse() {
    	
    }
    
    public void setPlan(Plan plan) {
    	this.plan=plan;
    }

    // Constructor Injection
    public Spouse(Plan plan) {
        this.plan = plan;
    }

    @Override
    public void setUserDetails(String name, int age, Long contact, String address) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.address = address;
    }

    @Override
    public void getUserDetails() {
        System.out.println(
            "Hello " + name +
            "\nAge: " + age +
            "\nContact: " + contact +
            "\nAddress: " + address
        );
        System.out.println(
            "You have selected a " + plan.getPlanName() + " for " + memberName
        );
    }

    @Override
    public Plan getUserPlan() {
        return plan;
    }
}