package szu.library.cs.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import szu.library.cs.pojo.Circulation;
import szu.library.cs.pojo.Reader;
import szu.library.cs.service.ICirculationService;
import szu.library.cs.service.IReaderService;

@Controller
@RequestMapping("/reader")
public class ReaderController {
	@Resource
	private IReaderService service;
	
	@Resource
	private ICirculationService cirService;
	
	@RequestMapping(value = "/selectById", method = RequestMethod.POST)
	@ResponseBody
	public Object selectReader(@RequestBody Map map) 	{
		System.out.println(map);
		return service.selectByPrimaryKey(Integer.parseInt((String) map.get("readerId")));
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public int insertReader(@RequestBody Map map) {
		Reader reader = new Reader();
		reader.setReaderName(map.get("readerName").toString());
		reader.setReaderGender(Integer.parseInt((String)map.get("readerGenderName")));
		reader.setReaderType(Integer.parseInt((String)map.get("readerType")));
		reader.setReaderAddress(map.get("readerAddress").toString());
		reader.setReaderTelephone(map.get("readerTelephone").toString());
		reader.setReaderRegisterDate(new Date());
		reader.setReaderBorrowbook(0);
		reader.setStatus(1);
		return service.insert(reader);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public int updateReader(@RequestBody Map map) throws ParseException {
		Reader reader = new Reader();
		reader.setReaderId(Integer.parseInt((String)map.get("readerId")));
		reader.setReaderName(map.get("readerName").toString());
		reader.setReaderGender(Integer.parseInt((String)map.get("readerGenderName")));
		reader.setReaderType(Integer.parseInt((String)map.get("readerType")));
		reader.setReaderAddress(map.get("readerAddress").toString());
		reader.setReaderTelephone(map.get("readerTelephone").toString());
		reader.setReaderBorrowbook(Integer.parseInt((String)map.get("readerBorrowbook")));
		reader.setStatus(Integer.parseInt((String)map.get("status")));
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date readerRegisterDate = df.parse((String) map.get("readerRegisterDate"));
		reader.setReaderRegisterDate(readerRegisterDate);
		return service.updateByPrimaryKey(reader);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public int deleteReader(@RequestBody Map map) {
		Map map1 = new HashMap();
		map1.put("readerId", (Integer.parseInt((String) map.get("readerId"))));
		map1.put("status", 9);
		return service.updateStatus(map1);
	}
	
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
	
//	@RequestMapping("/reader/queryById")
	@RequestMapping(value = "/queryById", method = RequestMethod.GET)  
	@ResponseBody  
	public Map<String, Object> queryById(String readerId,ModelMap model){
		Map<String, Object> map = new HashMap<String, Object>();  
		try{
			Reader reader = service.selectByPrimaryKey(Integer.parseInt(readerId));
			if(reader==null){
				map.put("success", "false"); 
				return map;
			}
			List<Circulation> cirList = cirService.getForReader(Integer.parseInt(readerId));
			map.put("data", reader);  
			map.put("circulationList", cirList);  
			map.put("success", "true");  
		}catch(Exception e){
			map.put("success", "false");  
		}
		return map;
	}

}
