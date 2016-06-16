package szu.library.cs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import szu.library.cs.pojo.Reader;

@Controller  
@RequestMapping("/user") 
public class TestJsonController {
	  
	  @RequestMapping(value = "/list", method = RequestMethod.GET)  
	  @ResponseBody  
	  public Map<String, Object> getUserList() {  
	    List<Reader> list = new ArrayList<Reader>();  
	    Reader um = new Reader();  
	    um.setReaderName("mdm");  
	    um.setReaderAddress("shen zhen");  
	    um.setReaderTelephone("134*******");  
	    list.add(um);  
	    Map<String, Object> modelMap = new HashMap<String, Object>();  
	    modelMap.put("total", "1");  
	    modelMap.put("data", list);  
	    modelMap.put("success", "true");  
	    return modelMap;  
	  }  
	  
	  @RequestMapping(value = "/list2", method = RequestMethod.POST)  
	  @ResponseBody  
	  public Map<String, String> addUser(@RequestBody Reader model) {  
	    
	    Map<String, String> map = new HashMap<String, String>();  
	    map.put("success", "true");  
	    return map;  
	  }  
}
