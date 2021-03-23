package com.example.FoodManagement.controller.dto;


import com.example.FoodManagement.model.Food;

import lombok.Data;

@Data
public class FoodGetDto {

	private Integer id;

	private String name;

	private String category;

	private String ingredients;

	private String makingTime;

	private String recipe;

	private Integer difficulty;

	public FoodGetDto(Food food) {
		this.id = food.getId();
		this.name = food.getName();
		this.category = food.getCategory();
		this.ingredients = food.getIngredients();
		this.makingTime = food.getMakingTime();
		this.recipe = food.getRecipe();
		this.difficulty = food.getDifficulty();
	}

}
