package com.example.FoodManagement.controller.dto;

import lombok.Data;

@Data
public class FoodModifyDto {

	private String name;

	private String category;

	private String ingredients;

	private String makingTime;

	private String recipe;

	private Integer difficulty;

	private Boolean isDeleted;

}
