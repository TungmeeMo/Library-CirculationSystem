package szu.library.cs.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import szu.library.cs.pojo.BookType;
import szu.library.cs.pojo.ReaderType;
import szu.library.cs.service.IReaderTypeService;

@Controller
@SessionAttributes("currUser")
@RequestMapping("/readerType")
public class ReaderTypeController {
	
	@Resource
	private IReaderTypeService service;
	
	@RequestMapping("/readerType/toNew")
	public String toNewReaderType(){
		return "/reader/newReaderType"; 
	}
	
	@RequestMapping("/readerType/new")
	public String newReaderType(ReaderType type,ModelMap model){
		
		try{
			String name = type.getTypeName();
			if( null == service.queryByName(name)){
				service.insert(type);
				model.put("message", "新增成功！");
			}else{
				model.put("message", "新增失败，读者类型名称已存在！");
			}
			
		}catch(Exception e){
			model.put("message", "新增失败，请重试！");
		}
		return "home";
	}
	
	@RequestMapping("/readerType/toShowlist")
	public String listAll(ModelMap model){
		
		try{
			List<ReaderType> list = service.getAll();
			model.put("list", list);
		}catch(Exception e){
		}
		return "/reader/listReaderType";
	}
	
	@RequestMapping("/readerType/toEdit")
	public String toEdit(HttpServletRequest request,ModelMap model){
		String id = request.getParameter("id"); 
		ReaderType type = service.selectByPrimaryKey(Integer.parseInt(id));
		model.put("readerType", type);
		return "/reader/editReaderType";
	}
	
	@RequestMapping("/readerType/update")
	public String update(ReaderType type,ModelMap model){
		try{
			service.updateByPrimaryKey(type);
			model.put("message", "更新成功！");
		}catch(Exception e){
			model.put("message", "更新失败，请重试！");
		}
		return listAll(model);
	}
	
	@RequestMapping("/readerType/delete")
	public String delete(HttpServletRequest request,ModelMap model){
		String id = request.getParameter("id"); 
		try{
			service.deleteByPrimaryKey(Integer.parseInt(id));
			model.put("message", "删除成功！");
		}catch(Exception e){
			model.put("message", "删除失败，请重试！");
		}
		return listAll(model);
	}
	
	@RequestMapping("/readerType/queryByName")
	public String queryByName(HttpServletRequest request,ModelMap model){
		String typeName = request.getParameter("typeName"); 
		try{
			ReaderType readerType = service.queryByName(typeName);
			model.put("readerType", readerType);
		}catch(Exception e){
			model.put("message", "查询失败，请重试！");
		}
		return "";
	}
	
}
