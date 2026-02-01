package com.example.tax;
import java.util.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class TaxApplication {

	public static void main(String[] args) {
		// Take ClassPathXmlApplicationContext from applicationContext.xml file
		System.out.println("Welcome to the Tax Payment Application");
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml"); 
		
		Tax incomeTax=(Tax) context.getBean("incomeTax");
		Tax propertyTax=(Tax) context.getBean("propertyTax");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Please select which tex you want to pay:");
		System.out.println("1. Income");
		System.out.println("2. Property");
		System.out.println("3. Exit");
		
		int taxChoice=sc.nextInt();
		
		switch (taxChoice) {
		case 1: {
			//System.out.println(incomeTax.getTaxType());
			
			if(incomeTax.isTaxPayed()==false) {
				System.out.println("Please enter your Income/Property value: ");
				int amt=sc.nextInt();
				incomeTax.setTaxableAmount(amt);
				incomeTax.calculateTaxAmount();
				System.out.println("You have selected income tax and your tax amount is: "+ incomeTax.getTaxAmount());
				System.out.println("Do you want to pay the tax: ");
				System.out.println("1. Yes");
				System.out.println("2. Exit");
				
				int choice=sc.nextInt();
				if(choice==1) {
					incomeTax.payTax();
				}else {
					System.out.println("Exiting...");
					break;
				}
			}else {
				System.out.println("You have already paid "+incomeTax.getTaxType()+" tax.");
			}
			
			break;
		}
		case 2: {
//			System.out.println(propertyTax.getTaxType());
			
			if(propertyTax.isTaxPayed()==false) {
				System.out.println("Please enter your Income/Property value: ");
				int amt=sc.nextInt();
				propertyTax.setTaxableAmount(amt);
				propertyTax.calculateTaxAmount();
				System.out.println("You have selected property tax and your tax amount is: "+ propertyTax.getTaxAmount());
				System.out.println("Do you want to pay the tax: ");
				System.out.println("1. Yes");
				System.out.println("2. Exit");
				
				int choice=sc.nextInt();
				if(choice==1) {
					propertyTax.payTax();
				}else {
					System.out.println("Exiting...");
					break;
				}
			}else {
				System.out.println("You have already paid "+propertyTax.getTaxType()+" tax.");
			}
			break;
			
		}
		case 3: {
			System.out.println("Exiting...");
			break;
		}
		default:
			System.out.println("Invalid choice");
		}
			
	}

}
