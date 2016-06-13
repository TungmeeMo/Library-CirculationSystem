package szu.library.cs.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import szu.library.cs.pojo.Book;
import szu.library.cs.service.IBookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Resource
	private IBookService service;
	
	@RequestMapping("/book/toNew")
	public String toNew(){
		return "/book/newBook"; 
	}
	
	@RequestMapping("/book/new")
	public String newBookType(Book book,ModelMap model){
		
		try{
			service.insert(book);
			model.put("message", "�����ɹ���");
		}catch(Exception e){
			model.put("message", "����ʧ�ܣ������ԣ�");
		}
		return "home";
	}
	
	@RequestMapping("/book/toEdit")
	public String toEdit(HttpServletRequest request,ModelMap model){
		String id = request.getParameter("id"); 
		Book book = service.selectByPrimaryKey(Integer.parseInt(id));
		model.put("book", book);
		return "/book/editBook";
	}
	
	@RequestMapping("/book/update")
	public String update(Book book,ModelMap model){
		try{
			service.updateByPrimaryKey(book);
			model.put("message", "���³ɹ���");
		}catch(Exception e){
			model.put("message", "����ʧ�ܣ������ԣ�");
		}
		return "";
	}
	
	@RequestMapping("/book/delete")
	public String delete(HttpServletRequest request,ModelMap model){
		String id = request.getParameter("id"); 
		try{
			service.deleteByPrimaryKey(Integer.parseInt(id));
			model.put("message", "ɾ���ɹ���");
		}catch(Exception e){
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
			model.put("message", "��ѯʧ�ܣ������ԣ�");
		}
		return "";
	}
}
