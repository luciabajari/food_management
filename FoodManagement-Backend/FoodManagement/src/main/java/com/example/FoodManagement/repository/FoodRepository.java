package com.example.FoodManagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.FoodManagement.model.Food;

public interface FoodRepository extends CrudRepository<Food, Integer> {
	List<Food> findByIsDeleted(Boolean isDeleted);
}
