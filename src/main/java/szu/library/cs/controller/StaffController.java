package szu.library.cs.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.storm.pojo.User;

import szu.library.cs.pojo.ReaderType;
import szu.library.cs.pojo.Staff;
import szu.library.cs.pojo.StaffAuthority;
import szu.library.cs.service.IStaffAuthorityService;
import szu.library.cs.service.IStaffService;

@Controller
@RequestMapping("/staff")
public class StaffController {

	@Resource
	private IStaffService service;
	
	@RequestMapping("/staff/toNew")
	public String toNew(){
		return "/staff/newStaff"; 
	}
	
	@RequestMapping("/staff/new")
	public String newStaff(Staff staff,ModelMap model){
		
		try{
			service.insert(staff);
			model.put("message", "�����ɹ���");
		}catch(Exception e){
			model.put("message", "����ʧ�ܣ������ԣ�");
		}
		return "home";
	}
	
	@RequestMapping("/staff/queryByName")
	public String queryByName(String staffName,ModelMap model){
		
		try{
			List<Staff> list = service.queryByName(staffName);
			model.put("list", list);
		}catch(Exception e){
		}
		return "";
	}
	
	@RequestMapping("/staff/toShowlist")
	public String listAll(ModelMap model){
		
		try{
			List<StaffAuthority> list = service.getAll();
			model.put("list", list);
		}catch(Exception e){
		}
		return "/staff/listStaff";
	}
	
	@RequestMapping("/staff/toEdit")
	public String toEdit(HttpServletRequest request,ModelMap model){
		String id = request.getParameter("id"); 
		Staff staff = service.selectByPrimaryKey(Integer.parseInt(id));
		model.put("staff", staff);
		return "/staff/editStaff";
	}
	
	@RequestMapping("/staff/update")
	public String update(Staff staff,ModelMap model){
		try{
			service.updateByPrimaryKey(staff);
			model.put("message", "���³ɹ���");
		}catch(Exception e){
			model.put("message", "����ʧ�ܣ������ԣ�");
		}
		return listAll(model);
	}
	
	@RequestMapping("/staff/delete")
	public String delete(HttpServletRequest request,ModelMap model){
		String id = request.getParameter("id"); 
		try{
			service.deleteByPrimaryKey(Integer.parseInt(id));
			model.put("message", "ɾ���ɹ���");
		}catch(Exception e){
			model.put("message", "ɾ��ʧ�ܣ������ԣ�");
		}
		return listAll(model);
	}
	
	
}
