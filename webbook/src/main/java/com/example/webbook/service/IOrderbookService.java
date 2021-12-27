package com.example.webbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.webbook.entity.LoginEntity;
import com.example.webbook.entity.OderbookEntity;

public interface IOrderbookService {

	List<OderbookEntity> findAll();

	OderbookEntity save(OderbookEntity entity);

	Optional<OderbookEntity> findById(Long id);

	List<OderbookEntity> findAllOrderbook();

	Page<OderbookEntity> findAll(Pageable pageable);

	List<OderbookEntity> findByEmail(String email);

	Page<OderbookEntity> findByEmailOderbook(String email, Pageable pageable);

	void deleteById(Long id);

	

	

	


}
