package com.example.TastyTrove;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class TastyTroveApplication {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example.TastyTrove");

		System.out.println("Welcome to Tasty Trove");

		// USER NAME
		System.out.print("Enter your name: ");
		String userName = scanner.nextLine();

		// RECIPE SELECTION
		System.out.println("""
				Select Cuisine:
				1. North Indian
				2. South Indian
				3. Chinese
				""");

		int recipeChoice = scanner.nextInt();
		scanner.nextLine(); // clear buffer

		Recipe recipe;

		switch (recipeChoice) {
		case 1 -> recipe = context.getBean("northIndian", Recipe.class);
		case 2 -> recipe = context.getBean("southIndian", Recipe.class);
		case 3 -> recipe = context.getBean("chinese", Recipe.class);
		default -> {
			System.out.println("Invalid choice");
			return;
		}
		}

		// INGREDIENT SELECTION
		System.out.println("""
				Select Ingredient:
				1. Lentils
				2. Rice
				3. Wheat
				""");

		int ingChoice = scanner.nextInt();

		String ingredient = switch (ingChoice) {
		case 1 -> "lentils";
		case 2 -> "rice";
		case 3 -> "wheat";
		default -> {
			System.out.println("Invalid ingredient");
			yield null;
		}
		};

		if (ingredient == null) {
			return;
		}

		// PASS DATA INTO SPRING BEANS
		recipe.setUserName(userName);
		recipe.setIngredients(ingredient);

		// FINAL OUTPUT
		recipe.getDetails();

		context.close();
		scanner.close();
	}
}