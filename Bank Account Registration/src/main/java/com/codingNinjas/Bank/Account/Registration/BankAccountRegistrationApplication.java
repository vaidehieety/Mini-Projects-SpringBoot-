package com.codingNinjas.Bank.Account.Registration;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BankAccountRegistrationApplication {

	public static void main(String[] args) {
		// AnnotationConfigApplicationContext context = new
		// AnnotationConfigApplicationContext(
		// "com.codingNinjas.Bank.Account.Registration");
		/*
		 * You need to complete this application as mentioned in the problem statement
		 * build your own logic and perform the following tasks.
		 * 
		 * 1. Fetch context from ApplicationContext.xml and initiate scanner. 2. Get
		 * user details from console. 3. Get account details from user and add them to
		 * the account list. 4. Display the list of accounts with their reference ids.
		 */
		// ClassPathXmlApplicationContext context = new
		// ClassPathXmlApplicationContext("ApplicationContext.xml");
		ApplicationContext context = SpringApplication.run(BankAccountRegistrationApplication.class, args);
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to Account Registration Application!");
		System.out.println("Please enter your name");
		String name = sc.nextLine();
		User user = context.getBean(User.class);
		user.setUserDetails(name);

		do {
			System.out.println("Do you want to add account?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int choice = sc.nextInt();
			sc.nextLine();

			if (choice == 1) {
				System.out.println("Please select account type");
				System.out.println("1. Current");
				System.out.println("2. Savings");
				int accChoice = sc.nextInt();
				Account account;
				if (accChoice == 1) {
					account = context.getBean(currentAccount.class);
				} else if (accChoice == 2) {
					account = context.getBean(savingsAccount.class);
				} else {
					System.out.println("Invalid Choice! Exiting...");
					return;
				}

				System.out.println("Enter the opening balance");
				int amount = sc.nextInt();
				account.addBalance(amount);
				user.addAccount(account);

			} else {
				break;
			}
		} while (true);

		System.out.println("Hi " + user.getName() + ", here is the list of your accounts:");

		List<Account> accountList = user.getAllAccounts();

		for (Account acc : accountList) {
			System.out.println(acc.getAccountType() + ": opening balance - " + acc.getBalance() + " Reference Id @"
					+ Integer.toHexString(System.identityHashCode(acc)));
		}

		sc.close();

	}

}
