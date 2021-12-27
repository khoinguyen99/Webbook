package com.example.webbook.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class OrderbookDTO {

	
	private long makh;
	
	
	@NotEmpty
	private String tenKH;
	
	@NotNull
	@Max(value = 10)
	private int soDT;
	
	public OrderbookDTO() {
		super();
	}

	public OrderbookDTO(long makh, @NotEmpty String tenKH, @NotNull @Max(10) int soDT, @NotEmpty @Email String email,
			@NotEmpty String tinhTP, @NotEmpty String diachi, @NotNull Date ngaymua) {
		super();
		this.makh = makh;
		this.tenKH = tenKH;
		this.soDT = soDT;
		this.email = email;
		this.tinhTP = tinhTP;
		this.diachi = diachi;
		this.ngaymua = ngaymua;
	}

	public long getMakh() {
		return makh;
	}

	public void setMakh(long makh) {
		this.makh = makh;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public int getSoDT() {
		return soDT;
	}

	public void setSoDT(int soDT) {
		this.soDT = soDT;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTinhTP() {
		return tinhTP;
	}

	public void setTinhTP(String tinhTP) {
		this.tinhTP = tinhTP;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public Date getNgaymua() {
		return ngaymua;
	}

	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}

	@NotEmpty
	@Email()
	private String email;
	
	
	@NotEmpty
	private String tinhTP;
	
	@NotEmpty
	private String diachi;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngaymua;
	
}
