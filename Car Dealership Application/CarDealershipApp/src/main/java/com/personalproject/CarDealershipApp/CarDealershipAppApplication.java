package com.personalproject.CarDealershipApp;
import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CarDealershipAppApplication {

	public static void main(String[] args) {
				
		Scanner sc=new Scanner(System.in);
		
		
		ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		
		System.out.println("Hi, please enter your name");
		String name=sc.nextLine();
		
		System.out.println("Please select your choice of car");
		System.out.println("1. Family Car");
		System.out.println("2. Sports Car");
		System.out.println("3. Truck");
		
		int choice=sc.nextInt();
		Car car=null;
		
		
		switch (choice) {
		case 1: {
			//take input for tyres
			System.out.println("Choose your types of tyres: \n1. Normal Tyres \n2.Sports Tyres");
			int num=sc.nextInt();
			if(num==1) {
				car=(Car)context.getBean("normalCarNormalTyre");
				
			}else if(num==2) {
				car=(Car)context.getBean("normalCarSportsTyre");
				
			}else {
				System.out.println("Error!");
			}
			break;
			
		}
		case 2:{
			
			System.out.println("Choose your types of tyres: \n1. Sports Tyres \n2. Heavy Tyres");
			int num=sc.nextInt();
			if(num==1) {
				car=(Car)context.getBean("sportsCarSportsTyre");
				
			}else if(num==2) {
				car=(Car)context.getBean("sportsCarHeavyTyre");
				
			}else {
				System.out.println("Error!");
			}
			break;
		}
		
		case 3:{
			car=(Car)context.getBean("truck");
			break;
		}
		default:
			System.out.println("Invalid choice!");
		}
		
		car.setOwnerName(name);
		System.out.println(car.getOwnerName()+" owns a "+car.getInfo());
		
		
		sc.close();
		context.close();
		
}

}
