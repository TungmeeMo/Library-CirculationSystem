package szu.library.cs.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import szu.library.cs.service.IBookService;
import szu.library.cs.service.ISystemSettingService;

@Controller
public class SystemSettingController {
	
	@Resource
	private ISystemSettingService service;
	
	@RequestMapping("/systemSetting/toNew")
	public String toNew(){
		return "/setting/neSystemSetting"; 
	}

}
