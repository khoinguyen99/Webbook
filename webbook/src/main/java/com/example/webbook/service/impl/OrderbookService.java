package com.example.webbook.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.webbook.entity.BookEntity;
import com.example.webbook.entity.LoginEntity;
import com.example.webbook.entity.OderbookEntity;
import com.example.webbook.respontories.LoginRespontory;
import com.example.webbook.respontories.OderRespontory;
import com.example.webbook.respontories.SachRespon;
import com.example.webbook.service.IOrderbookService;
import com.example.webbook.service.IShoppingcartService;

@Service
public class OrderbookService implements IOrderbookService {
          
	@Autowired
	SachRespon respon;
	
	@Autowired
	LoginRespontory loginRespontory;
	
	@Autowired
	IShoppingcartService  iShoppingcartService;
	
	@Autowired
	private OderRespontory oderRespontory;

	

	@Override
	public List<OderbookEntity> findByEmail(String email) {
		return oderRespontory.findByEmail(email);
	}
   

	@Override
	public void deleteById(Long id) {
		oderRespontory.deleteById(id);
	}


	@Override
	public OderbookEntity save(OderbookEntity entity) {
		
		
  	   
		
		return oderRespontory.save(entity);
	}

	
   
	



	







	@Override
	public Page<OderbookEntity> findByEmailOderbook(String email, Pageable pageable) {
		return oderRespontory.findByEmailOderbook(email, pageable);
	}


	@Override
	public List<OderbookEntity> findAll() {
		return oderRespontory.findAll();
	}

	@Override
	public Optional<OderbookEntity> findById(Long id) {
		return oderRespontory.findById(id);
	}

	@Override
	public Page<OderbookEntity> findAll(Pageable pageable) {
		return oderRespontory.findAll(pageable);
	}

	@Override
	public List<OderbookEntity> findAllOrderbook() {
		return oderRespontory.findAllOrderbook();
	}

	
	
	
	
	
}
