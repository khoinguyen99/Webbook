package com.example.webbook.entity;

import java.util.List;
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
@Table(name = "Account")
public class LoginEntity {
  
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;
	
	
	@Column(columnDefinition = "nvarchar(100)")
	private String username;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String password;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String quyen;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String name;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String diachi;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String email;
	
	@Column
	private int phone;
	
	@Column
	private Boolean status;
	
	
	@OneToMany(mappedBy = "loginentities",cascade = CascadeType.MERGE)
	public List<OderbookEntity> oderbookEntities;
	
	
	
	
   


	public LoginEntity(Long userid, String username, String password, String quyen, String name, String diachi,
			String email, int phone, Boolean status, List<OderbookEntity> oderbookEntities) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.quyen = quyen;
		this.name = name;
		this.diachi = diachi;
		this.email = email;
		this.phone = phone;
		this.status = status;
		this.oderbookEntities = oderbookEntities;
	}

	public List<OderbookEntity> getOderbookEntities() {
		return oderbookEntities;
	}

	public void setOderbookEntities(List<OderbookEntity> oderbookEntities) {
		this.oderbookEntities = oderbookEntities;
	}

	public LoginEntity() {
		super();
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	
	
	
	
	
}
