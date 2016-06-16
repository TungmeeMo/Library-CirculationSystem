package szu.library.cs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import szu.library.cs.pojo.BookType;
import szu.library.cs.pojo.Reader;
import szu.library.cs.service.IBookTypeService;

@Controller
@RequestMapping("/bookType")
public class BookTypeController {
	@Resource
	private IBookTypeService service;
	
	@RequestMapping("/bookType/toNew")
	public String toNew(){
		return "/book/newBookType"; 
	}
	
	@RequestMapping("/bookType/new")
	public String newBookType(BookType type,ModelMap model){
		
		try{
			String name = type.getTypeName();
			if( null == service.queryByName(name)){
				service.insert(type);
				model.put("message", "�����ɹ���");
			}else{
				model.put("message", "����ʧ�ܣ�ͼ�����������Ѵ��ڣ�");
			}
			
		}catch(Exception e){
			model.put("message", "����ʧ�ܣ������ԣ�");
		}
		return "home";
	}
	
	@RequestMapping("/bookType/toEdit")
	public String toEdit(HttpServletRequest request,ModelMap model){
		String id = request.getParameter("id"); 
		BookType type = service.selectByPrimaryKey(id);
		model.put("bookType", type);
		return "/book/editBookType";
	}
	
	@RequestMapping("/bookType/update")
	public String update(BookType type,ModelMap model){
		try{
			service.updateByPrimaryKey(type);
			model.put("message", "���³ɹ���");
		}catch(Exception e){
			model.put("message", "����ʧ�ܣ������ԣ�");
		}
		return "";
	}
	
	@RequestMapping("/bookType/delete")
	public String delete(HttpServletRequest request,ModelMap model){
		String id = request.getParameter("id"); 
		try{
			service.deleteByPrimaryKey(id);
			model.put("message", "ɾ���ɹ���");
		}catch(Exception e){
			model.put("message", "ɾ��ʧ�ܣ������ԣ�");
		}
		return "";
	}
	
	@RequestMapping("/bookType/queryByName")
	public String queryByName(HttpServletRequest request,ModelMap model){
		String typeName = request.getParameter("typeName"); 
		try{
			BookType bookType = service.queryByName(typeName);
			model.put("bookType", bookType);
		}catch(Exception e){
			model.put("message", "��ѯʧ�ܣ������ԣ�");
		}
		return "";
	}
	
	
}
