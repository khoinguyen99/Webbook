package com.example.webbook.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.example.webbook.entity.BookEntity;
import com.example.webbook.respontories.OderRespontory;
import com.example.webbook.respontories.SachRespon;
import com.example.webbook.service.IShoppingcartService;

@Service
@SessionScope
public class ShoppingcartService implements IShoppingcartService {
  
	private static List<BookEntity> list = new ArrayList<>();
	
	
	
	@Autowired
	private SachRespon respon;
	
	@Autowired
	private OderRespontory oderRespontory;
	
	private Map<Long,BookEntity> map = new HashMap<Long, BookEntity>();
	
	@Override
	public BookEntity findBybookId(Long maSach) {
		return respon.findBybookId(maSach);
	}



	public BookEntity getById(Long id) {
		return respon.getById(id);
	}

	
	
	
	@Override
	public void add(BookEntity book)
	{
	      
		BookEntity bookEntity = map.get(book.getMaSach());
	       
	       if(bookEntity != null)
	       {
	    	   bookEntity.setSoLuongBan(book.getSoLuongBan() + bookEntity.getSoLuongBan());
	    	
	    	   
	       }else
	       {
	    	   
	    	   map.put((long)book.getMaSach(), book);
	       }
	       
	       
	}
	
	
	
	@Override
	public BookEntity findById(Long maSach)
	{
		 int i =  maSach.intValue();
		return  list.get(i);
	}
	
	
	
	@Override
	public void remove(Long maSach)
	{
		
		
		map.remove(maSach);
	}
	
	@Override
	public Collection<BookEntity> getBookEntities()
	{
		return map.values();
	}
	
	@Override
	public void clear()
	{
		map.clear();
	}
	
	
	@Override
	public void update(Long maSach, int SoLuongBan)
	{
		BookEntity book = map.get(maSach);
		
		book.setSoLuongBan(SoLuongBan);
	    
		
		
		int x = book.getDonGia() * book.getSoLuongBan();
	    
		
		if(book.getSoLuongBan() <= 0)
		{
			map.remove(maSach);
		}
	}
	
	
		
	
	
	@Override
	public double getAmount()
	{
	 return	map.values().stream().mapToDouble(book->book.getSoLuongBan() * book.getDonGia()).sum();
	}
	
	
	@Override
	public int getCount()
	{
		if(map.isEmpty())
		{
			return map.values().size();
		}
		return map.values().size();
	}
	
	
	
	
}
