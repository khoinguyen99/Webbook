package com.example.webbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.webbook.entity.BookEntity;

public interface ISachService  {

	List<BookEntity> findByBookEntity(Long chudeid);

	

	Page<BookEntity> findAll(Pageable pageable);

	Page<BookEntity> findByBooksEntity(Long chudeid, Pageable pageable);

	List<BookEntity> findAll();

	void deleteById(Long id);

	BookEntity save(BookEntity entity);

	List<BookEntity> findAllBook();




	Optional<BookEntity> findById(Long id);



	List<BookEntity> findByBookId(Long maSach);



	List<BookEntity> findByNameBook(String name);



	List<BookEntity> findByBookTopOrder();



	



	



	



	

	

	

	

	

	

	

	

}
