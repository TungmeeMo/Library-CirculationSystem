package szu.library.cs.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import szu.library.cs.pojo.Book;
import szu.library.cs.service.IBookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Resource
	private IBookService service;
	
	@RequestMapping("/toNew")
	public String toNew(){
		return "/book/newBook"; 
	}
	
	@RequestMapping("/newBook")
	public String newBook(Book book,ModelMap model){
		
		try{
			Book bookTem = service.selectByPrimaryKey(book.getBookId());
			if(null == bookTem){
				service.insert(book);
				model.put("message", "�����ɹ���");
			}else{
				model.put("message", "����ʧ�ܣ�ͼ�������Ѵ��ڣ�");
			}
		}catch(Exception e){
			e.printStackTrace();
			model.put("message", "����ʧ�ܣ������ԣ�");
		}
		return "home";
	}
	
	@RequestMapping("/book/toEdit")
	public String toEdit(HttpServletRequest request,ModelMap model){
		String id = request.getParameter("id"); 
		Book book = service.selectByPrimaryKey(id);
		model.put("book", book);
		return "/book/editBook";
	}
	
	@RequestMapping("/book/update")
	public String update(Book book,ModelMap model){
		try{
			service.updateByPrimaryKey(book);
			model.put("message", "���³ɹ���");
		}catch(Exception e){
			e.printStackTrace();
			model.put("message", "����ʧ�ܣ������ԣ�");
		}
		return "";
	}
	
	@RequestMapping("/book/delete")
	public String delete(HttpServletRequest request,ModelMap model){
		String id = request.getParameter("id"); 
		try{
			service.deleteByPrimaryKey(id);
			model.put("message", "ɾ���ɹ���");
		}catch(Exception e){
			e.printStackTrace();
			model.put("message", "ɾ��ʧ�ܣ������ԣ�");
		}
		return "";
	}
	
	@RequestMapping("/book/queryByCriteria")
	public String queryByCriteria(Book book,ModelMap model){
		try{
			List<Book> bookList = service.queryByCriteria(book);
			model.put("bookList",bookList);
		}catch(Exception e){
			e.printStackTrace();
			model.put("message", "��ѯʧ�ܣ������ԣ�");
		}
		return "";
	}
	
//	@RequestMapping("/book/queryByBookId")
//	public String queryByBookId(String bookId,ModelMap model){
//		try{
//			Book book = service.selectByPrimaryKey(bookId);
//			model.put("book",book);
//		}catch(Exception e){
//			e.printStackTrace();
//			model.put("message", "��ѯʧ�ܣ������ԣ�");
//		}
//		return "";
//	}
	
	@RequestMapping(value = "/queryById", method = RequestMethod.GET)  
	@ResponseBody 
	public Map queryById(String bookId,ModelMap model){
		Map<String, Object> map = new HashMap<String, Object>();  
		try{
			Book book = service.selectByPrimaryKey(bookId);
			if(book==null){
				map.put("success", "false"); 
				return map;
			}
			map.put("data", book);  
			map.put("success", "true");  
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", "false");  
		}
		return map;
	}
	
}
