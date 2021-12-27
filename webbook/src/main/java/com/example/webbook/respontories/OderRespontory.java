package com.example.webbook.respontories;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.webbook.entity.OderbookEntity;

public interface OderRespontory extends JpaRepository<OderbookEntity, Long> {

	   @Query(value = "SELECT * FROM oderbook",nativeQuery = true)
	   List<OderbookEntity> findAllOrderbook();
	   
	   
	   @Query(value = "SELECT * FROM oderbook WHERE email = ?1", nativeQuery = true)
	   Page<OderbookEntity> findByEmailOderbook(String email,Pageable pageable);
	   
	   
	   List<OderbookEntity> findByEmail(String email); 
	   
}
