package com.example.FoodManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.FoodManagement.controller.dto.FoodModifyDto;

import lombok.Data;
import lombok.NoArgsConstructor;


//TODO: audit fields

@Data
@Entity
@Table(name = "food")
@NoArgsConstructor
public class Food {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;

	@Column
	private String category;

	@Column
	private String ingredients;

	@Column(name = "making_time")
	private String makingTime;

	@Column
	private String recipe;

	@Column
	private Integer difficulty;

	@Column
	private Boolean isDeleted;

	private void setCustomData(FoodModifyDto foodModifyDto){
		this.name = foodModifyDto.getName();
		this.category = foodModifyDto.getCategory();
		this.ingredients = foodModifyDto.getIngredients();
		this.makingTime = foodModifyDto.getMakingTime();
		this.recipe = foodModifyDto.getRecipe();
		this.difficulty = foodModifyDto.getDifficulty();
	}


	public Food(FoodModifyDto foodModifyDto) {
		setCustomData(foodModifyDto);
		this.isDeleted = false;
	}

	public void modifyFood(FoodModifyDto foodModifyDto) {
		setCustomData(foodModifyDto);
		this.isDeleted = foodModifyDto.getIsDeleted() != null ? foodModifyDto.getIsDeleted() : false;
	}

}