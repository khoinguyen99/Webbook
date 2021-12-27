package com.example.webbook.controller.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.webbook.entity.BookEntity;
import com.example.webbook.entity.CategoryEntity;
import com.example.webbook.entity.TheloaiEntity;
import com.example.webbook.respontories.TheLoaiRespon;
import com.example.webbook.service.IChudeService;
import com.example.webbook.service.ISachService;
import com.example.webbook.service.impl.LoginSecurityService;




@Controller(value = "controllerofweb")
@RequestMapping("/homepage")
public class HomeController {
     
	@Autowired
	private TheLoaiRespon loaiRespon;
	
	@Autowired
	private ISachService iSachService;
	
    @Autowired
    private IChudeService chudeService;
	
    @Autowired
	LoginSecurityService loginSecurityService;
    
	@RequestMapping("")
	public String showBook(ModelMap model,Principal principal) {
		
		List<BookEntity> bookEntities = iSachService.findByBookTopOrder();
		model.addAttribute("toporder", bookEntities);
		
		List<BookEntity> listbook = iSachService.findAllBook();
		model.addAttribute("listbooktop", listbook);
				
        List<CategoryEntity> list = chudeService.findAllChude();
        
        
		model.addAttribute("chudes", list);
		
	    
		 return "webapp/decorator/web";	
	}
	
	
	
	
	
	
//	@GetMapping("")
//	public String showBooks(ModelMap model) {
//		
//		 List<CategoryEntity> lists =  (List<CategoryEntity>)chudeService.findAll();
//		 model.addAttribute("chudes",lists);
//	
//		 return "webapp/commonr";	
//	}
	
	public Long sotn = (long)1;
	
	@ModelAttribute(name = "newchude")
	public List<CategoryEntity> getCategoryEntities() {
		return chudeService.findAllChude();
	}
	
	@GetMapping("/detailbook/{id}")
	public String showDetail(ModelMap model,@PathVariable(name = "id") Long id)
	{   
		 Optional<BookEntity> list1 = null; 		 		
		 list1 = iSachService.findById(id);		 	
		    
		 
		 
		 Document document = Jsoup.parse(list1.get().getShortDescription());
		
		   
		 
	     if(id !=null && id>=0)
	     {
	    	 model.addAttribute("detailsss",document.toString());	 
	    	 model.addAttribute("detailss",list1.get());	 
	     }
	     
		 return "webapp/views/web/chitietsach";
	}
	
	@GetMapping("/testpage")
	public String testPage()
	{   
		
	     
		 return "webapp/views/web/test2";
	}
	
	
	@SuppressWarnings("unlikely-arg-type")
	@GetMapping("/chude/{id}/{ids}")
	public String sach(ModelMap model,
			@PathVariable(name = "id") Long theloaiId,
			@PathVariable(name = "ids") Long ids,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size,			
			HttpSession session       ) {
	         
		     session.setAttribute("bookid",ids);
		     session.setAttribute("theloai",theloaiId);
		     
		    
		     
			 List<CategoryEntity> list = null; 
//	         List<BookEntity> list1 = null;
	          
	         
			 list = chudeService.findByCategoryEntity(theloaiId);
			 Optional<CategoryEntity> list2 = null;
			 list2 =  chudeService.findById(ids);
//			 list1 = iSachService.findByBookEntity(ids);
		 
		    int currentPage = page.orElse(1);
			int pageSize  =size.orElse(2);
			
			PageRequest pageable = PageRequest.of(currentPage-1, pageSize);
			Page<BookEntity> resultPage = null;
			
			
			
			
			
			
			if(ids!=null && ids>=0)
			{
				resultPage = iSachService.findByBooksEntity(ids,pageable);
				
				
				List<BookEntity> bookEntities = resultPage.getContent();
				List<BookEntity> bookEntities2 = new ArrayList<>();
				for (BookEntity bookEntity : bookEntities) {
					if(!bookEntities.contains(bookEntity.getTacGiaEntity().getTenTG()))
					{
						bookEntities2.add(bookEntity);
						
					}
					 
				}
				
				model.addAttribute("tentacgia", bookEntities);
				
				
				
			}else
			{
			
			    resultPage = iSachService.findAll(pageable);
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
		 model.addAttribute("chudess",resultPage);
		 model.addAttribute("chudesss",list2.get());
		 model.addAttribute("chudes",list);
		
		return "webapp/views/web/chude";
	}
	
	@GetMapping("/pageing")
	public String pageings(ModelMap model,
			
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		
		int currentPage = page.orElse(1);
		int pageSize  =size.orElse(2);
		
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
				else if(start==1) end  = start  + 5;
			}
			
			List<Integer> pageNumber = IntStream.rangeClosed(start, end)
					.boxed()
					.collect(Collectors.toList());
		    model.addAttribute("pageNumbers",pageNumber);			
			
		}
		 model.addAttribute("bookPages",resultPage);	
		return "webapp/views/web/tests";
	}
	
	@GetMapping("/login")
	public String loginuser(ModelMap model) {
		
		
       
	    
		 return "webapp/views/web/login";	
	}
	
	@GetMapping("/danhmuc/{id}")
	public String danhmucs(ModelMap model,@PathVariable(name = "id") Long theloaiId) {
		
		  Optional<TheloaiEntity> optional =  loaiRespon.findById(theloaiId);
          if(optional.isPresent())
          {
        	model.addAttribute("theloais",optional.get());  
          }
	    
		 return "/webapp/views/web/DanhMuc";	
	}
	
	@GetMapping("/search")
	public String loginusers(ModelMap model) {
		
		 
          
	    
		 return "/webapp/views/web/timkiems";	
	}
	
	@PostMapping("/search")
	public String timkiem(ModelMap model,@RequestParam(name = "keyword",required = false) String name) {
		   
	     List<BookEntity> bookEntities = iSachService.findByNameBook(name);
	     if(org.springframework.util.StringUtils.hasText(name))
	     {
	    	 if(bookEntities.isEmpty())
	    	 {
	    		 String notfind = "Tìm kiếm sản phẩm với từ khóa "+"''"+name+"''"+" không tìm thấy kết quả";
	    		 model.addAttribute("khongtimthay",notfind);
	    	 }else {
 	    	 model.addAttribute("tukhoa",name);
		     model.addAttribute("timkiembooks", bookEntities);
	    	 }
	     }else
	     {
	    	 return "redirect:/homepage/search";
	     }
	     
		 return "/webapp/views/web/timkiems";
	}
	
}
