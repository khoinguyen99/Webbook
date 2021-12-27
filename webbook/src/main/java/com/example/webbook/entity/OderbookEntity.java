package com.example.webbook.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "oderbook")
public class OderbookEntity {

   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long makh;
	
	
	
	@Column(columnDefinition = "nvarchar(100)")
	private String tenKH;
	
	@Column
	private int soDT;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String email;
	
	
	@Column(columnDefinition = "nvarchar(100)")
	private String tinhTP;
	
	
	
	@Column(columnDefinition = "nvarchar(1000)")
	private String diachi;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngaymua;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date thoigiangiaohang;
	
	@Column
	private int soluongsachmua;
	
    
	  public int getSoluongsachmua() {
		return soluongsachmua;
	}
 
    

   
	




	public OderbookEntity(long makh, String tenKH, int soDT, String email, String tinhTP, String diachi, Date ngaymua,
			Date thoigiangiaohang, int soluongsachmua, Set<BookEntity> bookEntities2, LoginEntity loginentities) {
		super();
		this.makh = makh;
		this.tenKH = tenKH;
		this.soDT = soDT;
		this.email = email;
		this.tinhTP = tinhTP;
		this.diachi = diachi;
		this.ngaymua = ngaymua;
		this.thoigiangiaohang = thoigiangiaohang;
		this.soluongsachmua = soluongsachmua;
		this.bookEntities2 = bookEntities2;
		this.loginentities = loginentities;
	}









	public Date getThoigiangiaohang() {
		return thoigiangiaohang;
	}









	public void setThoigiangiaohang(Date thoigiangiaohang) {
		this.thoigiangiaohang = thoigiangiaohang;
	}









	public void setSoluongsachmua(int soluongsachmua) {
		this.soluongsachmua = soluongsachmua;
	}



	@ManyToMany(cascade = CascadeType.MERGE)
	  @JoinTable(
	  name = "book_oder", 
	  joinColumns = @JoinColumn(name = "user_id"), 
	  inverseJoinColumns = @JoinColumn(name = "book_id"))
	  Set<BookEntity> bookEntities2;


	  
	  
	  
	    @ManyToOne(cascade = CascadeType.MERGE)
		@JoinColumn(name = "orderbookId")
	    public LoginEntity loginentities;
	  



	




	




	public LoginEntity getLoginentities() {
			return loginentities;
		}




		public void setLoginentities(LoginEntity loginentities) {
			this.loginentities = loginentities;
		}




	public OderbookEntity() {
		super();
	}




	








	public Set<BookEntity> getBookEntities2() {
		return bookEntities2;
	}









	public void setBookEntities2(Set<BookEntity> bookEntities2) {
		this.bookEntities2 = bookEntities2;
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



	










	
	
	
		
}
