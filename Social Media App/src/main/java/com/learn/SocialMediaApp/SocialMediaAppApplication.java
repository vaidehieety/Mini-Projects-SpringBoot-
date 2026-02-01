package com.learn.SocialMediaApp;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SocialMediaAppApplication {

	public static void main(String[] args) {
		// SpringApplication.run(SocialMediaAppApplication.class, args);

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Post post=(Post)context.getBean("simplePost");
		// Scanner setup
		Scanner sc = new Scanner(System.in);
		User user = (User) context.getBean("simpleUser");
		// prompt the user
		System.out.println("Social Media app! start");
		System.out.println("Please enter your name: ");
		String userName = sc.nextLine();
		user.setUserName(userName);
		// infinite loop
		while (true) {
			// fetch post list
			// PostList postList=(PostList)context.getBean("simplePostList");
			// System.out.println("reference to postlist is: "+postList.toString());
			PostList postList = user.getPostList();

			// prompt user for diff options
			System.out.println("1. Make new Post \n2. Show all posts \n3. Exit");
			int menuItem = sc.nextInt();

			switch (menuItem) {
			case 1: {
				Post post = (Post) context.getBean("simplePost");
				System.out.println("Please enter a post:");
				sc.nextLine(); // getting \n and moving to next input
				String message = sc.nextLine();
				post.setMessage(message);
				postList.setPost(post);

				break;
			}
			case 2: {
				System.out.println("All the posts !");
				for (int i = 0; i < postList.size(); i++) {
					// System.out.println("reference is: " + postList.getPost(i).toString());
					System.out.println(i + ". " + user.getUserName() + " " + postList.getPost(i).getMessage());
				}
				break;
			}

			case 3: {

//				System.out.println("Exiting...");
				break;

			}
			default:
				System.out.println("Error!");
			}

			if (menuItem == 3) {
				break;
			}

		}
		sc.close();
		context.close();
	}

}
