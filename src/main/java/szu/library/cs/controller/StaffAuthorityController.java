package szu.library.cs.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import szu.library.cs.pojo.BookType;
import szu.library.cs.pojo.StaffAuthority;
import szu.library.cs.service.IStaffAuthorityService;

@Controller
@SessionAttributes("currUser")
@RequestMapping("/staffAuthority")
public class StaffAuthorityController {
	
	@Resource
	private IStaffAuthorityService service;
	
	@RequestMapping("/staffAuthority/toNew")
	public String toNewAuthority(){
		return "/staff/newStaffAuthority"; 
	}
	
	@RequestMapping("/staffAuthority/new")
	public String newAuthority(StaffAuthority authority,ModelMap model){
		
		try{
			String name = authority.getAuthorityName();
			if(null ==service.queryByName(name)){
				service.insert(authority);
				model.put("message", "新增成功！");
			}else{
				model.put("message", "新增失败，权限名称已存在！");
			}
		}catch(Exception e){
			model.put("message", "新增失败，请重试！");
		}
		return "home";
	}
	
	@RequestMapping("/staffAuthority/toShowlist")
	public String listAll(ModelMap model){
		
		try{
			List<StaffAuthority> list = service.getAll();
			model.put("list", list);
		}catch(Exception e){
		}
		return "/staff/listAuthority";
	}
	
	@RequestMapping("/staffAuthority/toEdit")
	public String toEdit(HttpServletRequest request,ModelMap model){
		String authorityId = request.getParameter("id"); 
		StaffAuthority authority = service.selectByPrimaryKey(Integer.parseInt(authorityId));
		model.put("authority", authority);
		return "/staff/editStaffAuthority";
	}
	
	@RequestMapping("/staffAuthority/update")
	public String update(StaffAuthority authority,ModelMap model){
		try{
			service.updateByPrimaryKey(authority);
			model.put("message", "更新成功！");
		}catch(Exception e){
			model.put("message", "更新失败，请重试！");
		}
		return listAll(model);
	}
	
	@RequestMapping("/staffAuthority/delete")
	public String delete(HttpServletRequest request,ModelMap model){
		String authorityId = request.getParameter("id"); 
		try{
			service.deleteByPrimaryKey(Integer.parseInt(authorityId));
			model.put("message", "删除成功！");
		}catch(Exception e){
			model.put("message", "删除失败，请重试！");
		}
		return listAll(model);
	}
	
	@RequestMapping("/staffAuthority/queryByName")
	public String queryByName(HttpServletRequest request,ModelMap model){
		String name = request.getParameter("name"); 
		try{
			StaffAuthority staffAuthority = service.queryByName(name);
			model.put("staffAuthority", staffAuthority);
		}catch(Exception e){
			model.put("message", "查询失败，请重试！");
		}
		return "";
	}
	
	
	
}
