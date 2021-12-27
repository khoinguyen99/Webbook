package com.example.webbook.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class LoginDTO {

	
	private Long userid;
	
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String quyen;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String diachi;
	
	@NotEmpty
	private String email;
	
	@NotNull
	private int phone;
	
	
	private Boolean rememberME = false;


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


	public Boolean getRememberME() {
		return rememberME;
	}


	public void setRememberME(Boolean rememberME) {
		this.rememberME = rememberME;
	}


	public LoginDTO(Long userid, @NotEmpty String username, @NotEmpty String password, @NotEmpty String quyen,
			@NotEmpty String name, @NotEmpty String diachi, @NotEmpty String email, @NotNull int phone,
			Boolean rememberME) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.quyen = quyen;
		this.name = name;
		this.diachi = diachi;
		this.email = email;
		this.phone = phone;
		this.rememberME = rememberME;
	}


	public LoginDTO() {
		super();
	}
	
	
	
}
