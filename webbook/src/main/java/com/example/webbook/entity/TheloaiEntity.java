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
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "THELOAI")
public class TheloaiEntity {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	
	@Column(columnDefinition = "nvarchar(100)")
	private String nameTL;
	
	@OneToMany(mappedBy = "theloaiEntity",cascade = CascadeType.ALL)
	private Set<CategoryEntity> categoryEntities;
	
	
	@OneToMany(mappedBy = "theloaiEntity",cascade = CascadeType.ALL)
	private Set<BookEntity> bookentity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameTL() {
		return nameTL;
	}

	public void setNameTL(String nameTL) {
		this.nameTL = nameTL;
	}

	public Set<CategoryEntity> getCategoryEntities() {
		return categoryEntities;
	}

	public void setCategoryEntities(Set<CategoryEntity> categoryEntities) {
		this.categoryEntities = categoryEntities;
	}

	public Set<BookEntity> getBookentity() {
		return bookentity;
	}

	public void setBookentity(Set<BookEntity> bookentity) {
		this.bookentity = bookentity;
	}

	public TheloaiEntity(long id, String nameTL, Set<CategoryEntity> categoryEntities, Set<BookEntity> bookentity) {
		super();
		this.id = id;
		this.nameTL = nameTL;
		this.categoryEntities = categoryEntities;
		this.bookentity = bookentity;
	}

	public TheloaiEntity() {
		super();
	}

	
	
	
}
