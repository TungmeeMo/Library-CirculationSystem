package szu.library.cs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import szu.library.cs.pojo.BookType;
import szu.library.cs.pojo.Circulation;
import szu.library.cs.pojo.StaffAuthority;
import szu.library.cs.service.IStaffAuthorityService;

@Controller
@SessionAttributes("currUser")
@RequestMapping("")
public class StaffAuthorityController {
	
	@Resource
	private IStaffAuthorityService service;
	
	@RequestMapping("/staffAuthority/toNew")
	public String toNewAuthority(){
		return "/staff/newStaffAuthority"; 
	}
	
	
	@RequestMapping(value = "/staffAuthority/new", method = RequestMethod.POST)  
	@ResponseBody 
	public  Map<String, Object> newAuthority(@RequestBody StaffAuthority authority,ModelMap model){
		Map<String, Object> map = new HashMap<String, Object>();  
		
		try{
			String name = authority.getAuthorityName();
			if(null ==service.queryByName(name)){
				service.insert(authority);
				map.put("success", "true");
				map.put("message", "�����ɹ���");
			}else{
				map.put("success", "false");
				map.put("message", "����ʧ�ܣ�Ȩ�������Ѵ��ڣ�");
			}
		}catch(Exception e){
			map.put("success", "false");
			map.put("message", "����ʧ�ܣ������ԣ�");
		}
		return map;
	}
	
	@RequestMapping(value = "/staffAuthority/toShowlist", method = RequestMethod.GET)  
	@ResponseBody  
	public Map<String, Object> listAll(ModelMap model){
		Map<String, Object> map = new HashMap<String, Object>(); 
		try{
			List<StaffAuthority> list = service.getAll();
			map.put("success", "true");  
			map.put("list", list);
		}catch(Exception e){
			map.put("success", "false");  
		}
		return map;
	}
	
	
	@RequestMapping(value = "/staffAuthority/update", method = RequestMethod.POST)  
	@ResponseBody 
	public Map<String, Object> update(@RequestBody StaffAuthority authority,ModelMap model){
		Map<String, Object> map = new HashMap<String, Object>();  
		try{
			String name = authority.getAuthorityName();
			if(null ==service.queryByName(name)){
				service.updateByPrimaryKey(authority);
				map.put("success", "true");
				map.put("message", "���³ɹ���");
			}else{
				map.put("success", "false");
				map.put("message", "����ʧ�ܣ�Ȩ�������Ѵ��ڣ�");
			}
		}catch(Exception e){
			map.put("success", "false");  
			map.put("message", "����ʧ�ܣ������ԣ�");
		}
		return map;
	}
	
	@RequestMapping(value = "/staffAuthority/delete", method = RequestMethod.GET)  
	@ResponseBody 
	public Map<String, Object> delete(String authorityId,ModelMap model){
		Map<String, Object> map = new HashMap<String, Object>();  
		try{
			service.deleteByPrimaryKey(Integer.parseInt(authorityId));
			map.put("success", "true");
			map.put("message", "ɾ���ɹ���");
		}catch(Exception e){
			map.put("success", "false");
			map.put("message", "ɾ��ʧ�ܣ�");
		}
		return map;
	}
	
	@RequestMapping("/staffAuthority/queryByName")
	public String queryByName(HttpServletRequest request,ModelMap model){
		String name = request.getParameter("name"); 
		try{
			StaffAuthority staffAuthority = service.queryByName(name);
			model.put("staffAuthority", staffAuthority);
		}catch(Exception e){
			model.put("message", "��ѯʧ�ܣ������ԣ�");
		}
		return "";
	}
	
	
	
}
