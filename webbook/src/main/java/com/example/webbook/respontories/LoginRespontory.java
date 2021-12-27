package com.example.webbook.respontories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.webbook.entity.LoginEntity;

public interface LoginRespontory extends JpaRepository<LoginEntity,Long> {
 
	  
	   
	   @Query(value = "SELECT * FROM account where username=?1",nativeQuery = true)
	   Optional<LoginEntity> findByUser(String username);	 
	   
	   
	 
}
