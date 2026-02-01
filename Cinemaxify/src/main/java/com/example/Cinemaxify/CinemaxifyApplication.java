package com.example.Cinemaxify;
import java.util.*;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

@SpringBootApplication
public class CinemaxifyApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Cinemaxify Application");
        System.out.println("Please select the member you want the plan for:");
        System.out.println("1. Self");
        System.out.println("2. Spouse");

        int userChoice = sc.nextInt();

        System.out.println("Please select your plan:");
        System.out.println("1. Normal");
        System.out.println("2. Premium");

        int planChoice = sc.nextInt();
        sc.nextLine(); // ✅ consume newline

        User user;

        switch (userChoice) {
            case 1:
                if (planChoice == 1) {
                    user = (User) context.getBean("selfNormal");
                } else if (planChoice == 2) {
                    user = (User) context.getBean("selfPremium");
                } else {
                    System.out.println("Invalid plan choice");
                    return;
                }
                break;

            case 2:
                if (planChoice == 1) {
                    user = (User) context.getBean("spouseNormal");
                } else if (planChoice == 2) {
                    user = (User) context.getBean("spousePremium");
                } else {
                    System.out.println("Invalid plan choice");
                    return;
                }
                break;

            default:
                System.out.println("Invalid member choice");
                return;
        }

        // --- User details input ---
        System.out.println("Please enter your name:");
        String name = sc.nextLine();

        System.out.println("Please enter your age:");
        int age = sc.nextInt();

        System.out.println("Please enter your contact:");
        Long contact = sc.nextLong();
        sc.nextLine(); // ✅ consume newline

        System.out.println("Please enter your address:");
        String address = sc.nextLine();

        // --- Set & display details ---
        user.setUserDetails(name, age, contact, address);
        user.getUserDetails();

        System.out.println("Do you want to purchase plan for someone else?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int choice = sc.nextInt();
        if (choice == 2) {
            System.out.println("Thank you for using Cinemaxify!");
        }

        sc.close();
        context.close();
    }
}