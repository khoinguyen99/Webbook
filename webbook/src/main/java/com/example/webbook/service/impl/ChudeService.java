package com.example.webbook.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webbook.entity.CategoryEntity;
import com.example.webbook.respontories.ChuderRespontory;
import com.example.webbook.service.IChudeService;

@Service
public class ChudeService implements IChudeService {
          
	
	 @Autowired
	 private ChuderRespontory chuderRespontory;

	@Override
	public List<CategoryEntity> findAll() {
		return chuderRespontory.findAll();
	}

	@Override
	public List<CategoryEntity> findByCategoryEntity(Long theloaiid) {
		return chuderRespontory.findByCategoryEntity(theloaiid);
	}

	@Override
	public List<CategoryEntity> findAllChude() {
		return chuderRespontory.findAllChude();
	}

	@Override
	public Optional<CategoryEntity> findById(Long id) {
		return chuderRespontory.findById(id);
	}

	@Override
	public CategoryEntity save(CategoryEntity  entity) {
		return chuderRespontory.save(entity);
	}





	

	
    
	 
}
