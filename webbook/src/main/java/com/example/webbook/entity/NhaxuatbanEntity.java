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
@Table(name = "NhaXB")
public class NhaxuatbanEntity {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long maNXB;
	
	@Column(length = 100,columnDefinition = "nvarchar")
    private String tenNXB;
	
	@Column(columnDefinition = "nvarchar(100)")
    private String tenNXBS;
	
	public NhaxuatbanEntity() {
		super();
	}


	public NhaxuatbanEntity(long maNXB, String tenNXB, String tenNXBS, Set<BookEntity> bookEntities) {
		super();
		this.maNXB = maNXB;
		this.tenNXB = tenNXB;
		this.tenNXBS = tenNXBS;
		this.bookEntities = bookEntities;
	}


	public String getTenNXBS() {
		return tenNXBS;
	}


	public void setTenNXBS(String tenNXBS) {
		this.tenNXBS = tenNXBS;
	}


	@OneToMany(mappedBy = "nhaxuatbanEntity",cascade = CascadeType.ALL)
	private Set<BookEntity> bookEntities;


	public long getMaNXB() {
		return maNXB;
	}


	public void setMaNXB(long maNXB) {
		this.maNXB = maNXB;
	}


	public String getTenNXB() {
		return tenNXB;
	}


	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}


	public Set<BookEntity> getBookEntities() {
		return bookEntities;
	}


	public void setBookEntities(Set<BookEntity> bookEntities) {
		this.bookEntities = bookEntities;
	}


	


	
	
	
}
