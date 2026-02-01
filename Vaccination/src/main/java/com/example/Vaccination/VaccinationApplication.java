package com.example.Vaccination;
import java.util.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@SpringBootApplication
public class VaccinationApplication {

    public static void main(String[] args) {

        /*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

		 Tasks:
		1. Fetch context from ApplicationContext.xml and initiate Scanner.
		2. Fetch vaccine and User type choice.
		3. Get the required bean from context.
		4. Get the appointment details form user
		5. Display the appointment details
		6. Run the loop again to book for another user or else exit.
		 */
    	
    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	Scanner sc=new Scanner(System.in);
    	
    	System.out.println("Welcome to the Vaccination Application");
    	boolean goAhead=true;
    	
    	do {	
    	
    	System.out.println("Please choose your vaccine preference:");
    	System.out.println("1. Covid");
    	System.out.println("2. Polio");
    	System.out.println("3. Typhoid");
    	
    	int vacChoice=sc.nextInt();
    	sc.nextLine();
    	
    	System.out.println("Whom do you want to vaccinate: ");
    	System.out.println("1. Father");
    	System.out.println("2. Mother");
    	System.out.println("3. Self");
    	System.out.println("4. Spouse");
    	System.out.println("5. Exit");
    	
    	int who=sc.nextInt();
    	sc.nextLine();
    	
    	User user=null;
    	
    	switch (who) {
		case 1: {
			switch (vacChoice) {
			case 1: {
				user=(User)context.getBean("fatherCovid");
				break;
			}
			case 2: {
				user=(User)context.getBean("fatherPolio");
				break;
			}
			case 3: {
				user=(User)context.getBean("fatherTyphoid");
				break;
			}
			default:
				System.out.println("Invalid Vaccine Choice");
			}
			break;
		}
		case 2: {
			switch (vacChoice) {
			case 1: {
				user=(User)context.getBean("motherCovid");
				break;
				
			}
			case 2: {
				
				user=(User)context.getBean("motherPolio");
				break;
			}
			case 3: {
				user=(User)context.getBean("motherTyphoid");
				break;
			}
			default:
				System.out.println("Invalid Vaccine Choice");
			}
			break;
		}
		
		case 3: {
			switch (vacChoice) {
			case 1: {
				user=(User)context.getBean("selfCovid");
				break;
				
			}
			case 2: {
				
				user=(User)context.getBean("selfPolio");
				break;
			}
			case 3: {
				user=(User)context.getBean("selfTyphoid");
				break;
			}
			default:
				System.out.println("Invalid Vaccine Choice");
			}
			break;
		}
		
		case 4: {
			switch (vacChoice) {
			case 1: {
				user=(User)context.getBean("spouseCovid");
				break;
				
			}
			case 2: {
				
				user=(User)context.getBean("spousePolio");
				break;
			}
			case 3: {
				user=(User)context.getBean("spouseTyphoid");
				break;
			}
			default:
				System.out.println("Invalid Vaccine Choice");
			}
			
			
			break;
		}
		case 5:{
			System.out.println("Exiting...");
			goAhead=false;
			break;
		}
		default:
			continue;
		}
    	if(user==null) {
    		continue;
    	}
    	if(user.IsVaccinated()) {
			System.out.println("User already Vaccinated");
		}else {
			System.out.println("Please enter Father details:");
			
			
			System.out.print("Name: ");
			String name=sc.nextLine();
			
			System.out.print("Age: ");
			int age=sc.nextInt();
			sc.nextLine();
			
			System.out.print("Appointment date (YYYY-MM-DD): ");
			String date=sc.nextLine();
			
			System.out.print("Appointment time (HH:MM AM/PM): ");
			String time=sc.nextLine();
			
			System.out.print("Appointment location: ");
			String location=sc.nextLine();
			
			TimeAndLocation timeAndLocation= (TimeAndLocation)context.getBean("timeAndLocation");
			timeAndLocation.setDetails(time, location, date);
			user.setUserDetails(name, age, timeAndLocation);
			user.setAppointment();
			
		}
    	System.out.println("Do you want to register for someone else? ");
    	System.out.println("1. Yes");
    	System.out.println("2. No");
    	int again=sc.nextInt();
    	if(again==2) {
    		break;
    	}else {
    		continue;
    	}
    	}while(goAhead);
    	
    	System.out.println("Thank you for visiting!");

    }
}