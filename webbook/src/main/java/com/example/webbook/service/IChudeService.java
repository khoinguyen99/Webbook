package com.example.webbook.service;

import java.util.List;
import java.util.Optional;

import com.example.webbook.entity.CategoryEntity;

public interface IChudeService {

	List<CategoryEntity> findAll();

	List<CategoryEntity> findByCategoryEntity(Long theloaiid);

	List<CategoryEntity> findAllChude();

	Optional<CategoryEntity> findById(Long id);

	CategoryEntity save(CategoryEntity  entity);

	

	
	
	

	

	

	

	

 
}
