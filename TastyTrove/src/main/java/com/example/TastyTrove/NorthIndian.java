package com.example.TastyTrove;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("northIndian")
//@Scope("prototype")
public class NorthIndian implements Recipe {
	private String name = "NorthIndian";
	private String userName;
	private Ingredients ingredients;

	@Autowired
	@Qualifier("lentils")
	private Ingredients lentils;

	@Autowired
	@Qualifier("rice")
	private Ingredients rice;

	@Autowired
	@Qualifier("wheat")
	private Ingredients wheat;

	public void setIngredients(Ingredients ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public void setUserName(String name) {
		this.userName = name;
	}

	@Override
	public void getDetails() {
		this.ingredients.setIngredient(name);
		String dishName = this.ingredients.getDishDetail();
		List<String> ingredients = this.ingredients.getIngredientsDetail();
		System.out.println("Hello user " + this.userName + " we suggest you to make " + dishName
				+ " you can use the following ingredients:");
		for (int i = 0; i < ingredients.size(); i++) {
			System.out.println(i + 1 + ". " + ingredients.get(i));
		}
	}

	@Override
	public void setIngredients(String ingre) {
		if ("rice".equalsIgnoreCase(ingre)) {
			this.ingredients = this.rice;
		} else if ("wheat".equalsIgnoreCase(ingre)) {
			this.ingredients = this.wheat;
		} else if ("lentils".equalsIgnoreCase(ingre)) {
			this.ingredients = this.lentils;
		}
	}
}
