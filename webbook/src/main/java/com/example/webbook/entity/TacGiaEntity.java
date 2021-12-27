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
@Table(name = "TACGIA")
public class TacGiaEntity {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long maTG;
	
	
	@Column(columnDefinition = "nvarchar(100)")
	private String tenTG;
	
	@OneToMany(mappedBy = "tacGiaEntity",cascade = CascadeType.ALL)
	private Set<BookEntity> bookEntities;

	public long getMaTG() {
		return maTG;
	}

	public void setMaTG(long maTG) {
		this.maTG = maTG;
	}

	public String getTenTG() {
		return tenTG;
	}

	public void setTenTG(String tenTG) {
		this.tenTG = tenTG;
	}

	public Set<BookEntity> getBookEntities() {
		return bookEntities;
	}

	public void setBookEntities(Set<BookEntity> bookEntities) {
		this.bookEntities = bookEntities;
	}

	public TacGiaEntity(long maTG, String tenTG, Set<BookEntity> bookEntities) {
		super();
		this.maTG = maTG;
		this.tenTG = tenTG;
		this.bookEntities = bookEntities;
	}

	public TacGiaEntity() {
		super();
	}

	
	
	

}
