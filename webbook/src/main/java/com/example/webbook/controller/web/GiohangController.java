package com.example.webbook.controller.web;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.webbook.entity.BookEntity;
import com.example.webbook.entity.OderbookEntity;
import com.example.webbook.service.ILoginService;
import com.example.webbook.service.IOrderbookService;
import com.example.webbook.service.ISachService;
import com.example.webbook.service.IShoppingcartService;

@Controller
@RequestMapping("/GioHang")
public class GiohangController {
   
	 @Autowired
	 private ISachService sachService;
	
	 @Autowired
     private IShoppingcartService iShoppingcartService;
	 
	 @Autowired
	 ILoginService iLoginService;
	 
	 @Autowired
	 HttpSession session;
	 
	 @Autowired
	 private IOrderbookService iOrderbookService;
	 
	 List<OderbookEntity> oderbookEntities1 = new ArrayList<>();
	 Set<BookEntity> bookEntities = new HashSet<>();
	 Collection<BookEntity> bookEntities1 = null;
	 
	 
	 List<BookEntity> bookentity2 = new ArrayList<>();
	 
	 @GetMapping("/list")
	 public String addss(Model model )
	 {
		 model.addAttribute("books",sachService.findAll());
		 
		 
		 return "/webapp/views/webs/GioHang";
	 }
	 
	 
	 
	 @GetMapping("/lists")
	 public String adds(Model model)
	 {
		 
		 bookEntities1 = iShoppingcartService.getBookEntities();
		
		 session.setAttribute("count", iShoppingcartService.getCount());
		 model.addAttribute("books",bookEntities1);
		 model.addAttribute("total",iShoppingcartService.getAmount());
		 model.addAttribute("counts",iShoppingcartService.getCount());
		 
		
		 
		 return "/webapp/views/web/GioHang";
	 }
	 
	 @GetMapping("/add/{bookid}")
	 public String add(@PathVariable("bookid") Long bookId,Model model)
	 {
		 
		 
		 
		 BookEntity bookEntity =  iShoppingcartService.findBybookId(bookId);
		 if(bookEntity!=null)
		 {
			 
			 BookEntity bookEntity2 = new BookEntity();
			 BeanUtils.copyProperties(bookEntity, bookEntity2);
			 bookEntity2.setSoLuongBan(1);
			 iShoppingcartService.add(bookEntity2);
			 
			 bookEntities.add(bookEntity2);
			 
			 
			
			 
		 }
		 
		 return "redirect:/GioHang/lists";
	 }
	 
	 @GetMapping("remove/{bookid}")
	 public String remove(@PathVariable("bookid") Long maSach,ModelMap model)
	 {
		 iShoppingcartService.remove(maSach);
		 if(bookEntities1.isEmpty())
		 {
			 model.addAttribute("message","KHông có sản phẩm  nào");
		 }
		 model.addAttribute("messages","KHông có sản phẩm  nào");
		 return "redirect:/GioHang/lists";
	 }
	 
	 @PostMapping("update")
	 public String update(@RequestParam("bookid") Long maSach,
			 @RequestParam("soluongban") Integer soLuongBan
			 )
	 {
		 
		 
		 iShoppingcartService.update(maSach, soLuongBan);
		 
		 
		 
		 
		 return "redirect:/GioHang/lists";
	 }
	 
	 
	 
	 
	 @GetMapping("clear")
	 public String clear()
	 {
		 return "webapp/views/web/GioHang";
	 }
	 
	 
	    @GetMapping("/thanhtoan")
		public String add(ModelMap model) {
		
		   
		    
	    	  if(bookEntities1.size()<=0)
	    	  {
	    		  return "redirect:/GioHang/lists";
	    	  }
		     
		      model.addAttribute( "bookorders",bookEntities1);
		    
			  model.addAttribute("orders", new OderbookEntity());
			  model.addAttribute("total",iShoppingcartService.getAmount());
			
			return "webapp/views/web/DatSach";
		}
	    
	    public static int soluongbansach = 0;
	    @PostMapping("/saveOrUpdate")
		public String saveOrUpdate(ModelMap model,OderbookEntity entity,HttpSession session,BookEntity bookEntity) throws ParseException {
	    	    
	    	  
	    	 
	    	
	    	  Date date = new Date();
		      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    
			  Date t = 	 formatter.parse(formatter.format(date));
				
			  
				
			  Calendar cal = Calendar.getInstance();
			  cal.add(Calendar.DAY_OF_MONTH,5);
			  formatter.format(cal.getTime());
			  
			  entity.setNgaymua(t);
			  entity.setThoigiangiaohang(formatter.parse(formatter.format(cal.getTime())));
			  
			  entity.setBookEntities2(bookEntities);  
			  
			  List<BookEntity> listA = new ArrayList<>(bookEntities1);
			 
			  
			  for(int i=0;i<listA.size();i++)
			  {
				 bookEntity = listA.get(i);  
				 BookEntity listB = iShoppingcartService.findBybookId(bookEntity.getMaSach());
				
				 
				 int sosach = bookEntity.getSoLuongSach() - bookEntity.getSoLuongBan();
				 bookEntity.getSoLuongBan();
			     
				 
				 
				 if(sosach<0)
				 {
					 bookEntity.setSoLuongSach(0);
				 }
				 int soluongsachban = listB.getSoLuongBan() + bookEntity.getSoLuongBan();
				 
				 soluongbansach = soluongbansach + bookEntity.getSoLuongBan();
				 
				 entity.setSoluongsachmua(soluongbansach);
				
				
				 bookEntity.setSoLuongBan(soluongsachban);
				 bookEntity.setSoLuongSach(sosach);
				 
				 bookentity2.add(bookEntity);
				 
				 
				 
				 
				 sachService.save(bookEntity);
				 
			  }
			  
	    	  iOrderbookService.save(entity);   
	    	  
	    	  
	    	  
	    	  model.addAttribute( "bookorders",bookEntities1);
              model.addAttribute("orders",entity);
              model.addAttribute("total",iShoppingcartService.getAmount());
	          model.addAttribute("message","<script>alert('Đặt sách thành công');</script>");
	          
	         
			  return "redirect:/GioHang/thankyou";
		}
	    
	     @GetMapping("/donhang")
		 public String donhangs(ModelMap model,
				 @RequestParam("page") Optional<Integer> page,
				 @RequestParam("size") Optional<Integer> size) throws ParseException
		 {
		    	 String convertedToString = String.valueOf(session.getAttribute("emails"));
//		    	 List<OderbookEntity> optional = iOrderbookService.findByEmail(convertedToString);
//		    	 model.addAttribute("oroderaccount",optional);
	    		 
		    	  Date date = new Date();
			      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			    
				  Date t = 	 formatter.parse(formatter.format(date));
		    	 
		    	int currentPage = page.orElse(1);
	    		int pageSize  =size.orElse(2);
	    		
	    		PageRequest pageable = PageRequest.of(currentPage-1, pageSize);
	    		Page<OderbookEntity> resultPage = null;
	    		
	    		
	    		
	    		resultPage = iOrderbookService.findByEmailOderbook(convertedToString,pageable);
	    	    
                List<OderbookEntity> videosList = resultPage.getContent();
	    		
	    		
	    		for(int i=0;i<videosList.size();i++)
	    		{
	    			 OderbookEntity entitys = videosList.get(i);
	    			 if(entitys.getThoigiangiaohang().equals(t))
	    			 {
	    				 model.addAttribute("complete","<b>☑</b>");
	    			 }
	    			
	    		}
	    		
	    		
	    		int totalPages = (int) resultPage.getTotalElements();
	    		
	    		if(totalPages>0)
	    		{
	    			int start = Math.max(1,currentPage-2);
	    			int end = Math.min(currentPage+2, totalPages);
	    		   
	    			if (totalPages>5) {
	    				if(end==totalPages) start = end-5;
	    				else if(start==1) end  = start  + 5;
	    			}
	    			
	    			List<Integer> pageNumber = IntStream.rangeClosed(start, end)
	    					.boxed()
	    					.collect(Collectors.toList());
	    		    model.addAttribute("pageNumbers",pageNumber);			
	    			
	    		}
	    		 model.addAttribute("bookPages",resultPage);	
		    	
			 return "/webapp/views/web/DonHang";
		 }
	    
	     @GetMapping("/thankyou")
		 public String endpage()
		 {
	    	
			 return "webapp/views/web/thankpage";
		 }

	 	@GetMapping("/delete/{id}")
	 	public String delete(ModelMap model,@PathVariable(name="id") Long id,OderbookEntity entity,BookEntity bookEntity)
	 	{
	 		    
	 		
	 		    for(int i=0;i<bookentity2.size();i++)
	 		    {
	 		    	
	 		    	bookEntity = bookentity2.get(i);
	 		    	BookEntity listB = iShoppingcartService.findBybookId(bookEntity.getMaSach());
	 		    	
	 		    	int soluong = bookEntity.getSoLuongBan() + listB.getSoLuongSach();
	 		    	
	 		    	bookEntity.setSoLuongSach(soluong);
	 		    	bookEntity.setSoLuongBan(0);
	 		    	
	 		    	  sachService.save(bookEntity);  	
	 		    	
	 		    }
	 		  
	 		    iOrderbookService.deleteById(id);
	 		    
	 	        return "redirect:/GioHang/donhang/";	
	 	}
	 	
	 	 @PostMapping("/updates")
		 public String updates(ModelMap model,OderbookEntity entity,
				               @RequestParam("makh") Long makh,
				               @RequestParam(name="tenkh",required = false) String tenkh,
				               @RequestParam(name="email",required = false) String email,
				               @RequestParam(name="sodt",required = false) Integer sodt,
				               @RequestParam(name="tinhtp",required = false) String tinhtp,
				               @RequestParam(name="diachi",required = false) String diachi
				               
				 ) throws ParseException
		 {
			 
			 
			 for(int i=0;i<oderbookEntities1.size();i++)
			 {
				 entity= oderbookEntities1.get(i);
				 if(entity.getMakh()==makh)
				 {
					 entity.setTenKH(tenkh);
					 entity.setEmail(email);
					 entity.setSoDT(sodt);
					 entity.setTinhTP(tinhtp);
					 entity.setDiachi(diachi);
					  
					  
					  
					  
					 iOrderbookService.save(entity);
				 }
			 }
				
			 
			 
			 
			 return "redirect:/GioHang/donhang";
		 }
	 	
	 	@GetMapping("/editorder/{id}")
		public String showEdit(ModelMap model,@PathVariable(name="id") Long id,HttpSession session,OderbookEntity entity) 
		{  
			      
		 	      Optional<OderbookEntity>  depart = iOrderbookService.findById(id);
		 	      
		 	      
		 	      if(depart.isPresent())
		 	      { 
		 	    	  
		 	    	  entity = depart.get();
		 	    	  oderbookEntities1.add(entity);
			          model.addAttribute("orderbooks",depart.get());
		 	      }
				  
		
		          return "/webapp/views/web/EditOder";	
		}
	 
}
