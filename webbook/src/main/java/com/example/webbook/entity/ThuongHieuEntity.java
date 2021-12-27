package com.example.webbook.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "THUONGHIEU")
public class ThuongHieuEntity {
  
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long maTH;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String tenTH;
	
	@OneToMany(mappedBy = "thuongHieuEntity",cascade = CascadeType.ALL)
	public Set<BookEntity> bookEntities;

	public long getMaTH() {
		return maTH;
	}

	public void setMaTH(long maTH) {
		this.maTH = maTH;
	}

	public String getTenTH() {
		return tenTH;
	}

	public void setTenTH(String tenTH) {
		this.tenTH = tenTH;
	}

	public Set<BookEntity> getBookEntities() {
		return bookEntities;
	}

	public void setBookEntities(Set<BookEntity> bookEntities) {
		this.bookEntities = bookEntities;
	}

	public ThuongHieuEntity(long maTH, String tenTH, Set<BookEntity> bookEntities) {
		super();
		this.maTH = maTH;
		this.tenTH = tenTH;
		this.bookEntities = bookEntities;
	}

	public ThuongHieuEntity() {
		super();
	}
	
}
