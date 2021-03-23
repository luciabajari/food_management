package com.example.FoodManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FoodManagement.controller.dto.FoodGetDto;
import com.example.FoodManagement.controller.dto.FoodModifyDto;
import com.example.FoodManagement.service.FoodService;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin
@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private FoodService foodService;

	@Operation(summary = "Get a food by its id")
	@GetMapping("/{id}")
	public FoodGetDto getFoodById(@PathVariable Integer id) {
		return foodService.getFoodById(id);
	}

	//--
	@Operation(summary = "Get all foods")
	@GetMapping("/all")
	public List<FoodGetDto> getAllFoods() {
		return foodService.getAllFoodByIsDeleted(Boolean.FALSE);
	}

	@Operation(summary = "Get deleted foods")
	@GetMapping("/all-deleted")
	public List<FoodGetDto> getDeletedFoods() {
		return foodService.getAllFoodByIsDeleted(Boolean.TRUE);
	}

	@Operation(summary = "Insert food")
	@PostMapping("/insert")
	public FoodGetDto insertFood(@RequestBody FoodModifyDto foodModifyDto) {
		return foodService.insertFood(foodModifyDto);
	}

	@Operation(summary = "Update food")
	@PostMapping("/update/{id}")
	public FoodGetDto updateFood(@PathVariable Integer id, @RequestBody FoodModifyDto foodModifyDto) {
		return foodService.updateFood(id, foodModifyDto);
	}

	@Operation(summary = "Delete food")
	@PostMapping("/delete/{id}")
	public FoodGetDto deleteFood(@PathVariable Integer id) {
		return foodService.deleteFood(id);
	}

}