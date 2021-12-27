package com.example.webbook.entity;

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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name = "Sach")
public class BookEntity{
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long maSach;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String tenSach;
	
	
	private int donGia;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String donViTinh;
	
	@Column(columnDefinition = "NTEXT")
	private String shortDescription;
	
	
	@Column(columnDefinition = "NTEXT")
	private String shortJavascript;
	
	public BookEntity(long maSach, String tenSach, int donGia, String donViTinh, String shortDescription,
			String shortJavascript, String moTa, String thumbnail, Date ngaycapnhat, int soLuongBan, int soLuongSach,
			int soLanXem, String kichThuoc, int maGiamGia, ThuongHieuEntity thuongHieuEntity,
			CategoryEntity categoryEntity, NhaxuatbanEntity nhaxuatbanEntity, TacGiaEntity tacGiaEntity,
			Set<OderbookEntity> entities, TheloaiEntity theloaiEntity) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.donGia = donGia;
		this.donViTinh = donViTinh;
		this.shortDescription = shortDescription;
		this.shortJavascript = shortJavascript;
		this.moTa = moTa;
		this.thumbnail = thumbnail;
		this.ngaycapnhat = ngaycapnhat;
		this.soLuongBan = soLuongBan;
		this.soLuongSach = soLuongSach;
		this.soLanXem = soLanXem;
		this.kichThuoc = kichThuoc;
		this.maGiamGia = maGiamGia;
		this.thuongHieuEntity = thuongHieuEntity;
		this.categoryEntity = categoryEntity;
		this.nhaxuatbanEntity = nhaxuatbanEntity;
		this.tacGiaEntity = tacGiaEntity;
		this.entities = entities;
		this.theloaiEntity = theloaiEntity;
	}


	public Set<OderbookEntity> getEntities() {
		return entities;
	}


	public void setEntities(Set<OderbookEntity> entities) {
		this.entities = entities;
	}


	public String getShortJavascript() {
		return shortJavascript;
	}


	public void setShortJavascript(String shortJavascript) {
		this.shortJavascript = shortJavascript;
	}


	@Column(columnDefinition = "nvarchar(2000)")
	private String moTa;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String thumbnail;
	


	public long getMaSach() {
		return maSach;
	}


	public void setMaSach(long maSach) {
		this.maSach = maSach;
	}


	public String getTenSach() {
		return tenSach;
	}


	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}


	public int getDonGia() {
		return donGia;
	}


	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}


	public String getDonViTinh() {
		return donViTinh;
	}


	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}


	public String getShortDescription() {
		return shortDescription;
	}


	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


	public String getMoTa() {
		return moTa;
	}


	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}


	public String getThumbnail() {
		return thumbnail;
	}


	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


	


	public int getSoLuongBan() {
		return soLuongBan;
	}


	public void setSoLuongBan(int soLuongBan) {
		this.soLuongBan = soLuongBan;
	}


	public int getSoLuongSach() {
		return soLuongSach;
	}


	public void setSoLuongSach(int soLuongSach) {
		this.soLuongSach = soLuongSach;
	}


	public int getSoLanXem() {
		return soLanXem;
	}


	public void setSoLanXem(int soLanXem) {
		this.soLanXem = soLanXem;
	}


	public String getKichThuoc() {
		return kichThuoc;
	}


	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}


	public int getMaGiamGia() {
		return maGiamGia;
	}


	public void setMaGiamGia(int maGiamGia) {
		this.maGiamGia = maGiamGia;
	}


	public ThuongHieuEntity getThuongHieuEntity() {
		return thuongHieuEntity;
	}


	public void setThuongHieuEntity(ThuongHieuEntity thuongHieuEntity) {
		this.thuongHieuEntity = thuongHieuEntity;
	}


	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}


	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}


	public NhaxuatbanEntity getNhaxuatbanEntity() {
		return nhaxuatbanEntity;
	}


	public void setNhaxuatbanEntity(NhaxuatbanEntity nhaxuatbanEntity) {
		this.nhaxuatbanEntity = nhaxuatbanEntity;
	}


	public TacGiaEntity getTacGiaEntity() {
		return tacGiaEntity;
	}


	public void setTacGiaEntity(TacGiaEntity tacGiaEntity) {
		this.tacGiaEntity = tacGiaEntity;
	}


	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaycapnhat;
	
	public Date getNgaycapnhat() {
		return ngaycapnhat;
	}
    
	

	public void setNgaycapnhat(Date ngaycapnhat) {
		this.ngaycapnhat = ngaycapnhat;
	}
	private int soLuongBan;
	
	private int soLuongSach;
	
	private int soLanXem;
	
	@Column(length = 2000)
	private String kichThuoc;
	
	private int maGiamGia;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "thuonghieuid")
	public ThuongHieuEntity thuongHieuEntity;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "chudeid")
	public CategoryEntity categoryEntity;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "nhaxuatbanid")
	public NhaxuatbanEntity nhaxuatbanEntity;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tacgiaid")
	public TacGiaEntity tacGiaEntity;
	
	
	
	
	@ManyToMany(mappedBy = "bookEntities2",cascade = CascadeType.MERGE)
	Set<OderbookEntity> entities;


    
	



 
	


	public BookEntity() {
		super();
	}


	
//	<div class="image"><a href="#" title="50"><img src="#" alt="50" title="50 "></a>
//    <span class="saleprice"></span>
//</div>
//<div th:utext="${theloai.bookentity}"></div>
//<div class="productname">
//	<a href="#" title="50"></a>
//</div>
//<div class="fields"> <span><a href="/thuong-hieu/1599/richard-watson.html" title="Richard Watson">Richard Watson</a></span></div>
//
//
//<div class="prices">107.100 ₫</div>
//<span class="rootprice">126.000 ₫</span>
//	
    

	@Override
	public String toString() {
		
		int dongia = (this.donGia)*20/100;
		int giamgia = this.donGia - dongia;
		
		return "<div>[ Tên Sách: "+this.tenSach+"\n\r Tên tác giả: "+this.tacGiaEntity.getTenTG()+"\n\rGiá: "+this.donGia+"\n\r Giá giảm giá:"+giamgia+"</div>" ;
	}


	


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "theloaiId")
	private TheloaiEntity theloaiEntity;



	public TheloaiEntity getTheloaiEntity() {
		return theloaiEntity;
	}


	public void setTheloaiEntity(TheloaiEntity theloaiEntity) {
		this.theloaiEntity = theloaiEntity;
	}


	
	

	
    

	



	




	

	

	
}
