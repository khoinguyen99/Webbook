package com.example.webbook.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.webbook.entity.BookEntity;
import com.example.webbook.respontories.SachRespon;
import com.example.webbook.service.ISachService;

@Service
public class SachService implements  ISachService{
  
	@Autowired
	SachRespon respon;

	@Override
	public List<BookEntity> findByBookEntity(Long chudeid) {
		return respon.findByBookEntity(chudeid);
	}

	@Override
	public List<BookEntity> findAll() {
		return respon.findAll();
	}

	
   
	
	@Override
	public List<BookEntity> findAllBook() {
		return respon.findAllBook();
	}

	@Override
	public BookEntity save(BookEntity entity) {
		return respon.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		respon.deleteById(id);
	}



	@Override
	public Page<BookEntity> findAll(Pageable pageable) {
		return respon.findAll(pageable);
	}

	@Override
	public Page<BookEntity> findByBooksEntity(Long chudeid, Pageable pageable) {
		return respon.findByBooksEntity(chudeid, pageable);
	}
    
	
	
	  
	@Override
	public Optional<BookEntity> findById(Long id) {
		return respon.findById(id);
	}

	@Override
	public List<BookEntity> findByBookId(Long maSach) {
		return respon.findByBookId(maSach);
	}

	@Override
	public List<BookEntity> findByNameBook(String name) {
		return respon.findByNameBook("%"+name+"%");
	}

	@Override
	public List<BookEntity> findByBookTopOrder() {
		return respon.findByBookTopOrder();
	}

	
	

	
	
	
	

     
	
	
	
}
