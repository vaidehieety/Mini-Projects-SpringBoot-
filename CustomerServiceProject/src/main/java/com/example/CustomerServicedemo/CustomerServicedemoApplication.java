package com.example.CustomerServicedemo;
import java.util.Scanner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.Customers.CustomerCare;
import com.example.Customers.PaymentDepartment;

@SpringBootApplication
public class CustomerServicedemoApplication {

	public static void main(String[] args) {

		/*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

			 Tasks:
		 *  1. Load the beans from ApplicationContext.xml
		 *  2. Display all the departments available and get the input from user.
		 *  3. Get the message from user and store it into the respective department.
		 *  
		 */
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Welcome to our Customer Care Application");
		
		System.out.println("Please enter your name: ");
		String name=sc.nextLine();
		System.out.println("Thanks for reaching us "+name);
		
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		CustomerCare paymentDepartment=(CustomerCare) context.getBean("paymentDepartment");
		CustomerCare queryDepartment=(CustomerCare) context.getBean("queryDepartment");
		CustomerCare salesDepartment=(CustomerCare) context.getBean("salesDepartment");
		
		System.out.println("Please select a department to connect to: ");
		System.out.println("1. Payment Department");
		System.out.println("2. Query Department");
		System.out.println("3. Sales Department");
		System.out.println("0. Exit");
		
		int choice=sc.nextInt();
		
		switch (choice) {
		case 1: {
			paymentDepartment.setCustomerName(name);
			paymentDepartment.getService();
			System.out.println("How may i assist you?");
			
			String problem=sc.nextLine();
			paymentDepartment.setProblem(problem);
			paymentDepartment.getProblem();
			break;
			
		}

		case 2: {
			queryDepartment.setCustomerName(name);
			queryDepartment.getService();
			System.out.println("How may i assist you?");
			
			String problem=sc.nextLine();
			queryDepartment.setProblem(problem);
			queryDepartment.getProblem();
			break;
		}

		case 3: {
			salesDepartment.setCustomerName(name);
			salesDepartment.getService();
			System.out.println("How may i assist you?");
			
			String problem = sc.nextLine();
			
			salesDepartment.setProblem(problem);
			salesDepartment.getProblem();
			break;
		}

		case 0: {
			System.out.println("Exiting...");
			break;
			
		}
		default:
			System.out.println("Invalid Input");
		}
}
}
