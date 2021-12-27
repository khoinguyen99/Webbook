package com.example.webbook.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CHUDE")
public class CategoryEntity {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	@Column(columnDefinition = "nvarchar(100)")
	private String name;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "theloaiId")
	private TheloaiEntity theloaiEntity;
    
	@OneToMany(mappedBy = "categoryEntity",cascade = CascadeType.ALL)
	private Set<BookEntity> bookEntities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TheloaiEntity getTheloaiEntity() {
		return theloaiEntity;
	}

	public void setTheloaiEntity(TheloaiEntity theloaiEntity) {
		this.theloaiEntity = theloaiEntity;
	}

	public Set<BookEntity> getBookEntities() {
		return bookEntities;
	}

	@Override
	public String toString() {
		return "CategoryEntity [id=" + id + ", name=" + name + ", theloaiEntity=" + theloaiEntity + ", bookEntities="
				+ bookEntities + "]";
	}

	public void setBookEntities(Set<BookEntity> bookEntities) {
		this.bookEntities = bookEntities;
	}

	public CategoryEntity(Long id, String name, TheloaiEntity theloaiEntity, Set<BookEntity> bookEntities) {
		super();
		this.id = id;
		this.name = name;
		this.theloaiEntity = theloaiEntity;
		this.bookEntities = bookEntities;
	}

	public CategoryEntity() {
		super();
	}
    
	
	
	
	
	
}
