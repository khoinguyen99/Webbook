package com.example.webbook.respontories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.webbook.entity.BookEntity;

public interface SachRespon extends JpaRepository<BookEntity,Long>{
    
	@Query(value = "SELECT * FROM sach WHERE ten_sach LIKE ?1", nativeQuery = true)
	List<BookEntity> findByNameBook(String name);
	
	@Query(value = "SELECT * FROM sach WHERE chudeid = ?1", nativeQuery = true)
	List<BookEntity> findByBookEntity(Long chudeid);
	
	@Query(value = "SELECT * FROM sach WHERE chudeid = ?1", nativeQuery = true)
	Page<BookEntity> findByBooksEntity(Long chudeid,Pageable pageable);
	
	@Query(value = "SELECT * FROM sach WHERE ma_sach = ?1", nativeQuery = true)
	BookEntity findBybookId(Long maSach);
	
	@Query(value = "SELECT * FROM sach WHERE ma_sach = ?1", nativeQuery = true)
	List<BookEntity> findByBookId(Long maSach);
	
	
	
	
	@Query(value = "select top 10 * from sach order by so_luong_ban desc", nativeQuery = true)
	List<BookEntity> findByBookTopOrder();
	
	@Query(value = "SELECT Top 10 * FROM sach ", nativeQuery = true)
	List<BookEntity> findAllBook();
}
