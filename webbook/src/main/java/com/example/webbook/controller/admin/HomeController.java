package com.example.webbook.controller.admin;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.webbook.entity.BookEntity;
import com.example.webbook.entity.CategoryEntity;
import com.example.webbook.entity.NhaxuatbanEntity;
import com.example.webbook.entity.OderbookEntity;
import com.example.webbook.entity.TacGiaEntity;
import com.example.webbook.entity.TheloaiEntity;
import com.example.webbook.entity.ThuongHieuEntity;
import com.example.webbook.respontories.ChuderRespontory;
import com.example.webbook.respontories.NhaXuatBanRespon;
import com.example.webbook.respontories.TacGiaRespon;
import com.example.webbook.respontories.TheLoaiRespon;
import com.example.webbook.respontories.ThuongHieuRespon;
import com.example.webbook.service.IChudeService;
import com.example.webbook.service.IOrderbookService;
import com.example.webbook.service.ISachService;
import com.example.webbook.service.impl.LoginSecurityService;

@Controller(value = "Controllerofadmin")
@RequestMapping("/admin")
public class HomeController {
	
	@Autowired
	private ChuderRespontory chuderRespontory;
	
	@Autowired
	private TheLoaiRespon loaiRespon; 
	
    @Autowired
    private NhaXuatBanRespon banRespon;
	
	@Autowired
	private ThuongHieuRespon hieuRespon;
	
	@Autowired
	private TacGiaRespon tacgiaRespon;
	
	@Autowired
	private ISachService iSachService;
	
	@Autowired
    private IChudeService chudeService;
	
	@Autowired
	private IOrderbookService iOrderbookService;
	
	@Autowired
	LoginSecurityService loginSecurityService;
	
	@Autowired
	private HttpSession session;
	
	List<BookEntity> bookEntities1 = new ArrayList<>();
	List<BookEntity> bookEntities2 = new ArrayList<>();
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String mainAdmin(ModelMap model,Principal principal)
	{
	  
		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = loginSecurityService.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);
		return "/webapp/decorator/admin";
	}
	
	
	
	@GetMapping("listbook")
	public String listbook(
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size,ModelMap model)
	{
		    int currentPage = page.orElse(1);
			int pageSize  =size.orElse(5);
			
			PageRequest pageable = PageRequest.of(currentPage-1, pageSize);
			Page<OderbookEntity> resultPage = null;
			
			 resultPage = iOrderbookService.findAll(pageable);
			 
			 
			 List<OderbookEntity> bookEntities = new ArrayList<>();
			 bookEntities.addAll(resultPage.getContent());
			 
			
				
			 
		for (OderbookEntity oderbookEntity : bookEntities) {
				 Set<BookEntity> bookEntities2 = oderbookEntity.getBookEntities2();
				 model.addAttribute("oderbookss",bookEntities2);
				
			}
	
			
		   
		   
		   
		    
		
			
			
			
			
			int totalPages = (int) resultPage.getTotalElements();
			
			if(totalPages>0)
			{
				int start = Math.max(1,currentPage-2);
				int end = Math.min(currentPage+2, totalPages);
			   
				if (totalPages>5) {
					if(end==totalPages) start = end-5;
					else if(start==1) end  = start  +5;
				}
				
				List<Integer> pageNumber = IntStream.rangeClosed(start, end)
						.boxed()
						.collect(Collectors.toList());
			    model.addAttribute("pageNumbers",pageNumber);			
				
			}
			
		 model.addAttribute("bookPages",resultPage);	
		
		return "/webapp/views/admin/layout-sidenav-light";
	}
//    
//	@GetMapping("listbooks")
//	public String listbooks(ModelMap model)
//	{
//	    List<BookEntity>  book =    iSachService.findAll();
//	    model.addAttribute("books", book);      
//		return "/webapp/views/admin/layout-static";
//	}
	
	@GetMapping("/add")
	public String add(ModelMap model) {
		BookEntity bookEntity = new BookEntity();	
//		CategoryEntity bookEntities3 = new CategoryEntity();
		model.addAttribute("books", bookEntity);
//		model.addAttribute("chudes",bookEntities3);
		return "/webapp/views/admin/addbook";
	}
	
	
	
	
	@PostMapping("/pageUpdate")
	public String pageUpdate(ModelMap model, BookEntity entity,
			CategoryEntity bookEntities3,
			@RequestParam("tenth") String tenth,
			@RequestParam("tentg") String tentg,
			@RequestParam("tennxb") String tennxb,
			@RequestParam("tencd") String tenCD,
			@RequestParam("tentl") String tenTL,
			@RequestParam("ngaycn") String date) throws ParseException
	{      
		
		  
		 
		   NhaxuatbanEntity bookEntities = new NhaxuatbanEntity() ;
		   TacGiaEntity bookEntities1 = new TacGiaEntity() ;
		   ThuongHieuEntity bookEntities2 = new ThuongHieuEntity();
		 
		   TheloaiEntity bookEntities4 = new TheloaiEntity();
		   bookEntities.setTenNXBS(tennxb);
		   bookEntities1.setTenTG(tentg);
		   bookEntities2.setTenTH(tenth);
		   bookEntities3.setName(tenCD);
		   bookEntities4.setNameTL(tenTL);
		   bookEntities3.setTheloaiEntity(bookEntities4);
		    
		   chudeService.save(bookEntities3);
//		   model.addAttribute("chudes",bookEntities3);
		   
		   entity.setCategoryEntity(bookEntities3);
		   entity.setNhaxuatbanEntity(bookEntities);
		   entity.setTacGiaEntity(bookEntities1);
		   entity.setThuongHieuEntity(bookEntities2);
		   entity.setTheloaiEntity(bookEntities4);
		   Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date); 
		   
		   entity.setNgaycapnhat(date1);
		   iSachService.save(entity);
		   model.addAttribute("books",entity);
		   
		   return "redirect:/admin/add";	
	}
	
	@ModelAttribute(name = "thuonghieus")
	public List<ThuongHieuEntity> getPerson() {
		
		return hieuRespon.findAll();
	}
	
	@ModelAttribute(name = "tacgias")
	public List<TacGiaEntity> getTacGia() {
		
		return tacgiaRespon.findAll();
	}
	
	@ModelAttribute(name = "nhaxuatbans")
	public List<NhaxuatbanEntity> getNhaXuatBan(){
		
		return banRespon.findAll();
	}
	
	@ModelAttribute(name = "chudes")
	public List<CategoryEntity> getChuDe() {
		
		return chuderRespontory.findAll();
	}
	
	@ModelAttribute(name = "theloais")
	public List<TheloaiEntity> getTheLoai() {
		
		return loaiRespon.findAll();
	}
	
	@GetMapping("/edit/{id}")
	public String showEdit(ModelMap model,@PathVariable(name="id") Long id,HttpSession session,BookEntity entity) 
	{  
		      
	 	      Optional<BookEntity>  depart = iSachService.findById(id);
	 	    
	 	      if(depart.isPresent())
	 	      {
	 	    
	 	       
	 	       bookEntities1.add(depart.get());
	 	       
		       
			   model.addAttribute("books",depart.get());
	 	      }
			  
	
	        return "/webapp/views/admin/editbook";	
	}
	
	@PostMapping("/pageUpdates")
	public String pageUpdates(ModelMap model, BookEntity entity,ThuongHieuEntity entity2,TacGiaEntity entity3,NhaxuatbanEntity entity4,CategoryEntity entity5,TheloaiEntity entity6,
			@RequestParam("id") Long mas,
			@RequestParam("shorts") String shorts,
			@RequestParam("tensach") String tensach,
			@RequestParam("image") String image,
			@RequestParam("dongia") int dongia,
			@RequestParam("soluong") int soluong,
			
			@RequestParam("magg") int magg,
			@RequestParam("kichthuoc") String kichthuoc,
			@RequestParam("mota") String mota,
			@RequestParam("kieusach") String kieusach,
			@RequestParam("ngaycapnhat") String ngaycapnhat,
			@RequestParam("tenth") String tenth,
			@RequestParam("math") Long math,
			@RequestParam("matg") Long matg,
			@RequestParam("tentg") String tentg,
			
			@RequestParam("manxb") Long manxb,
			@RequestParam("tennxb") String tennxb,
			@RequestParam("macd") Long macd,
			@RequestParam("tencd") String tencd,
			@RequestParam("matl") Long matl,
			@RequestParam("tentl") String tentl,
			@RequestParam("selectth") long selectth,
			
			@RequestParam("selectth1") long selecttg,
			
			@RequestParam("selectth2") long selectnxb,
			
			@RequestParam("selectth3") long selectcd,
			
			@RequestParam("selectth4") long selecttl
			
		
			
			) throws ParseException
	{      
		    
		   
		 
		    
		 
		   
		    
	       for(int i=0;i<bookEntities1.size();i++)
	       {
	    	   entity = bookEntities1.get(i);
	    	  
	    	   
	    	   
	    	   if(entity.getMaSach() == mas)
	    	   {
	    		   
	    		   if(entity.getThuongHieuEntity().getMaTH() != selectth)
	    		   {   
	    			   
//	    			   || entity.getTacGiaEntity().getMaTG() != selecttg || entity.getNhaxuatbanEntity().getMaNXB() != selectnxb || entity.getCategoryEntity().getId() != selectcd || entity.getTheloaiEntity().getId() != selecttl
	    			   Optional<ThuongHieuEntity> optional1 =  hieuRespon.findById(selectth);
	    			   
//	    			   
	    			   entity2 = optional1.get();
	    			  
	    			   
	    			  
		    		   entity.setThuongHieuEntity(entity2);   
		    		  
		    		   
	    		   }
	    		   
	    		   if(entity.getTacGiaEntity().getMaTG() != selecttg)
	    		   {
	    			   Optional<TacGiaEntity> optional2 =  tacgiaRespon.findById(selecttg);
	    			   entity3 = optional2.get();
	    			   entity.setTacGiaEntity(entity3); 
	    		   }
	    		   
	    		   if(entity.getNhaxuatbanEntity().getMaNXB() != selectnxb)
	    		   {
	    			   Optional<NhaxuatbanEntity> optional3 =  banRespon.findById(selectnxb);
	    			   entity4 = optional3.get();
	    			   entity.setNhaxuatbanEntity(entity4);  
	    		   }
	    		   
	    		   if(entity.getCategoryEntity().getId() != selectcd)
	    		   {
	    			   Optional<CategoryEntity> optional4 = chuderRespontory.findById(selectcd);
	    			 
	    			   entity5 = optional4.get();
	    			  
	    			   
	    			   if(entity5.getTheloaiEntity().getId() == selecttl)
	    			   {
	    				   Optional<TheloaiEntity> optional5 =  loaiRespon.findById(selecttl);
	    				   entity6 = optional5.get();
	    				   entity.setCategoryEntity(entity5);
		    			   
		    			   entity.setTheloaiEntity(entity6); 
	    			   }else
	    			   {
	    				   model.addAttribute("error","Chu de va the loai khong hop le");
	    			   }
	    			   
	    			 
	    			   
	    			   
	    			   
	    		   }
	    		   
//	    		   if(entity.getTheloaiEntity().getId()  !=  selecttl)
//	    		   {
//	    			   Optional<TheloaiEntity> optional5 =  loaiRespon.findById(selecttl);
//	    			   entity6 = optional5.get();
//	    			   entity.setTheloaiEntity(entity6);   
//	    		   }
	    		   
	    		   
	    		   
	    		   entity.setMaSach(mas);
		 	       entity.setTenSach(tensach);
		 	       entity.setThumbnail(image);
		 	       entity.setDonGia(dongia);
		 	       entity.setSoLuongSach(soluong);
		 	       entity.setMaGiamGia(magg);
		 	       entity.setKichThuoc(kichthuoc);
		 	       entity.setDonViTinh(kieusach);
		 	       
			       entity.setShortDescription(shorts);
			       entity.setMoTa(mota);
			       
		           Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(ngaycapnhat); 
				   
				   entity.setNgaycapnhat(date1);
				   iSachService.save(entity);
				 
				   
				        
					   
					   Optional<ThuongHieuEntity> optional1 =  hieuRespon.findById(math);
					   Optional<TacGiaEntity> optional2 =  tacgiaRespon.findById(matg);
					   Optional<NhaxuatbanEntity> optional3 =  banRespon.findById(manxb);
					   Optional<CategoryEntity> optional4 =  chuderRespontory.findById(macd);
					   Optional<TheloaiEntity> optional5 =  loaiRespon.findById(matl);
					  
					   entity2 = optional1.get();
					   entity3 = optional2.get();
					   entity4 = optional3.get();
					   entity5 = optional4.get();
					   entity6 = optional5.get();
					   
					 if(entity2.getMaTH() == math || entity3.getMaTG() == matg || entity4.getMaNXB() == manxb || entity5.getId()==macd || entity6.getId()==matl)
					 {
						   entity2.setTenTH(tenth);
						   entity3.setTenTG(tentg);
						   entity4.setTenNXBS(tennxb);
						   entity5.setName(tencd);
						   entity6.setNameTL(tentl);
						   
						   hieuRespon.save(entity2);
						   tacgiaRespon.save(entity3);
						   banRespon.save(entity4);
						   chuderRespontory.save(entity5);
						   loaiRespon.save(entity6);
						   
						   
						   
					 }
					
				 
				   
				   
				   
				   
				   
			 
	    	   }else
	    	   {
	    		   System.out.print("Loi======================");
	    	   }
	       }
		 
	   
		   return "redirect:/admin/listbooks";	
	}
	
	@GetMapping("listbooks")
	public String sach(ModelMap model,
			
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size		
			  ) {
	         
	
		    int currentPage = page.orElse(1);
			int pageSize  =size.orElse(5);
			
			PageRequest pageable = PageRequest.of(currentPage-1, pageSize);
			Page<BookEntity> resultPage = null;
			
			
			
			
			resultPage = iSachService.findAll(pageable);
			
			int totalPages = (int) resultPage.getTotalElements();
			
			if(totalPages>0)
			{
				int start = Math.max(1,currentPage-2);
				int end = Math.min(currentPage+2, totalPages);
			   
				if (totalPages>5) {
					if(end==totalPages) start = end-5;
					else if(start==1) end  = start  +5;
				}
				
				List<Integer> pageNumber = IntStream.rangeClosed(start, end)
						.boxed()
						.collect(Collectors.toList());
			    model.addAttribute("pageNumbers",pageNumber);			
				
			}
		 model.addAttribute("bookPages",resultPage);	
		
		 
		
		return "/webapp/views/admin/layout-static";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name="id") Long id)
	{
		    
		
		    iSachService.deleteById(id);
		    
	        return "redirect:/admin/listbooks";	
	}
	
	
	
	
	
	
	
}
