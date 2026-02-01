//package com.example.EventRegistration;
//
//import java.util.Scanner;
//
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//@SpringBootApplication
//public class EventRegistrationApplication {
//
//	public static void main(String[] args) {
//		// Import scanner and take ClassPathXmlApplicationContext.
//		Scanner sc = new Scanner(System.in);
//
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		System.out.println("Welcome to the Graduation Ceremony Registration Application");
//		// Take the college event bean from the application context.
//		CollegeEvent event = (CollegeEvent) context.getBean("event");
//		// Print the event details.
//		event.printEventDetails();
//		while (true) {
//			System.out.println("Do you want to register for the ceremony\n1. Yes\n2. No");
//			int input = sc.nextInt();
//			sc.nextLine();
//			if (input == 1) {
//				/*
//				 * 1. Take attendee details from the console. 2. Get studentAttendee bean from
//				 * context and set the attendee details 3. Register the attendee for the event.
//				 * 4. Print the registration confirmation.
//				 */
//				System.out.println("Please enter your name");
//				String name = sc.nextLine();
//				System.out.println("Please enter your department");
//				String department = sc.nextLine();
//				System.out.println("In which year did you pass out?");
//				int batch = sc.nextInt();
//				sc.nextLine();
//
//				StudentAttendee attendee = (StudentAttendee) context.getBean("student");
//				attendee.setAttendeeDetails(name, department, batch);
//				event.registerStudent(attendee);
//				attendee.printRegistrationConfirmation();
//
//			} else if (input == 2) {
//				break;
//			} else {
//				System.out.println("Invalid Choice");
//				return;
//			}
//		}
//
//		// Get the number of attendees and print along with the statement below
//		System.out.println("No. of attendees registered are: " + event.getAttendeeCount());
//		System.out.println("The list of attendees are:");
//		// Print all the attendee names with their reference ids as given in the sample
//		// output..
////		for (int i = 0; i < event.getAttendeeCount(); i++) {
////			System.out.println(
////					event.getAllAttendees() + " Reference id: " + event.getAllAttendees().get(i).toString());
////		}
//	}
//
//}
package com.example.EventRegistration;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class EventRegistrationApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Take the college bean from application context.
		College college = (College) context.getBean("college");
		// Print the college name in the below print statement.
		System.out
				.println("Welcome to the Graduation Ceremony Registration Application for " + college.getCollegeName());
		// Get the college event bean from the college bean.
		CollegeEvent event = (CollegeEvent) context.getBean("event");
		event.printEventDetails();
		while (true) {
			System.out.println("Do you want to register for the ceremony\n1. Yes\n2. No");
			int input = scanner.nextInt();
			if (input == 1) {
				System.out.println("Please enter your name");
				scanner.nextLine();
				String name = scanner.nextLine();
				System.out.println("Please enter your department");
				String department = scanner.nextLine();
				System.out.println("In which year did you pass out?");
				int batch = scanner.nextInt();
				Attendee user = (Attendee) context.getBean("student");
				user.setAttendeeDetails(name, department, batch);
				event.registerStudent(user);
				user.printRegistrationConfirmation();
			} else if (input == 2) {
				break;
			} else {
				System.out.println("Invalid Choice");
				return;
			}
		}

		System.out.println("No. of attendees registered are: " + event.getAttendeeCount());
		System.out.println("The list of attendees are:");
		for (Attendee attendee : event.getAllAttendees()) {
			int userReferenceLength = attendee.toString().length(); // 46
			System.out.println(attendee.getAttendeeName() + "\t Reference id: "
					+ attendee.toString().substring(userReferenceLength - 9, userReferenceLength));
		}

		scanner.close();
		context.close();
	}

}
