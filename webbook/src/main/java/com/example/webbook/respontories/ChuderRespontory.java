package com.example.webbook.respontories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.webbook.entity.CategoryEntity;

public interface ChuderRespontory extends JpaRepository<CategoryEntity, Long> {
   List<CategoryEntity> findByNameContaining(String name);
   
   @Query(value = "SELECT * FROM chude WHERE theloai_id = ?1", nativeQuery = true)
   List<CategoryEntity> findByCategoryEntity(Long theloaiid);
   
   
   @Query(value = "SELECT * FROM chude",nativeQuery = true)
   List<CategoryEntity> findAllChude();
   
   
}
