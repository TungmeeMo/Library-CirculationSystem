package szu.library.cs.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import szu.library.cs.pojo.Book;
import szu.library.cs.pojo.Reader;
import szu.library.cs.pojo.ReaderType;
import szu.library.cs.service.IReaderService;

@Controller
@RequestMapping("/reader")
public class ReaderController {
	@Resource
	private IReaderService service;
	
	@RequestMapping("/reader/toNew")
	public String toNew(){
		return "/reader/newReader"; 
	}
	
	@RequestMapping("/reader/new")
	public String newReader(Reader reader,ModelMap model){
		
		try{
			service.insert(reader);
			model.put("message", "新增成功！");
		}catch(Exception e){
			model.put("message", "新增失败，请重试！");
		}
		return "home";
	}
	
	@RequestMapping("/reader/queryByName")
	public String queryByName(String readerName,ModelMap model){
		
		try{
			List<Reader> list = service.queryByName(readerName);
			model.put("list", list);
		}catch(Exception e){
		}
		return "";
	}
	
	
	@RequestMapping("/reader/toEdit")
	public String toEdit(HttpServletRequest request,ModelMap model){
		String id = request.getParameter("id"); 
		Reader reader = service.selectByPrimaryKey(Integer.parseInt(id));
		model.put("reader", reader);
		return "/reader/editStaff";
	}
	
	@RequestMapping("/reader/update")
	public String update(Reader reader,ModelMap model){
		try{
			service.updateByPrimaryKey(reader);
			model.put("message", "更新成功！");
		}catch(Exception e){
			model.put("message", "更新失败，请重试！");
		}
		return "";
	}
	
	@RequestMapping("/reader/delete")
	public String delete(HttpServletRequest request,ModelMap model){
		String id = request.getParameter("id"); 
		try{
			service.deleteByPrimaryKey(Integer.parseInt(id));
			model.put("message", "删除成功！");
		}catch(Exception e){
			model.put("message", "删除失败，请重试！");
		}
		return "";
	}
	
	@RequestMapping("/reader/queryByCriteria")
	public String queryByCriteria(Reader reader,ModelMap model){
		try{
			List<Reader> list = service.queryByCriteria(reader);
			model.put("readerList",list);
		}catch(Exception e){
			model.put("message", "查询失败，请重试！");
		}
		return "";
	}

}
