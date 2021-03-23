package com.example.FoodManagement.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FoodManagement.controller.dto.FoodGetDto;
import com.example.FoodManagement.controller.dto.FoodModifyDto;
import com.example.FoodManagement.exception.handler.FoodManagementException;
import com.example.FoodManagement.model.Food;
import com.example.FoodManagement.repository.FoodRepository;

@Service
public class FoodService {

	private static final String FOOD_NOT_FOUND = "Food not found!";

	@Autowired
	private FoodRepository foodRepository;

	public FoodGetDto getFoodById(Integer id) {
		return new FoodGetDto(getFood(id));
	}

	public List<FoodGetDto> getAllFoodByIsDeleted(Boolean isDeleted) {

		List<FoodGetDto> foodsDtoList = new ArrayList<>();
		foodRepository.findByIsDeleted(isDeleted).forEach(food -> foodsDtoList.add(new FoodGetDto(food)));
		return foodsDtoList;
	}

	//TODO: order by last insert

	public FoodGetDto insertFood(FoodModifyDto foodModifyDto) {
		Food food = new Food(foodModifyDto);
		foodRepository.save(food);
		return getFoodById(food.getId());

	}

	public FoodGetDto updateFood(Integer id, FoodModifyDto foodModifyDto){
		Food food = getFood(id);
		food.modifyFood(foodModifyDto);
		foodRepository.save(food);
		return new FoodGetDto(food);

	}

	public FoodGetDto deleteFood(Integer id){
		Food food = getFood(id);
		food.setIsDeleted(Boolean.TRUE);
		foodRepository.save(food);
		return new FoodGetDto(food);
	}

	private Food getFood(Integer id) {
		Optional<Food> optionalFood = foodRepository.findById(id);
		return optionalFood.map(o -> optionalFood.get())
				.orElseThrow(() -> new FoodManagementException(FOOD_NOT_FOUND));
	}


}
