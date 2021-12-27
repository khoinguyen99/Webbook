package com.example.webbook.service;

import java.util.Collection;

import com.example.webbook.entity.BookEntity;

public interface IShoppingcartService {

	

	BookEntity findById(Long maSach);

	BookEntity findBybookId(Long maSach);

	int getCount();

	double getAmount();

	void update(Long maSach, int SoLuongBan);

	void clear();

	Collection<BookEntity> getBookEntities();

	void remove(Long maSach);

	void add(BookEntity book);

}
