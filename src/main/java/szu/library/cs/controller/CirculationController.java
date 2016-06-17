package szu.library.cs.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import szu.library.cs.pojo.Book;
import szu.library.cs.pojo.Circulation;
import szu.library.cs.pojo.Reader;
import szu.library.cs.pojo.ReaderType;
import szu.library.cs.pojo.circulationDetail;
import szu.library.cs.service.IBookService;
import szu.library.cs.service.ICirculationDetailService;
import szu.library.cs.service.ICirculationService;
import szu.library.cs.service.IReaderService;
import szu.library.cs.service.IReaderTypeService;

@Controller
@RequestMapping("/circulation")
public class CirculationController {
	
	@Resource
	private ICirculationService service;
	
	@Resource
	private IReaderService readerService;
	
	@Resource
	private IReaderTypeService readerTypeService;
	
	@Resource
	private ICirculationDetailService circulationDetailService;
	
	@Resource
	private IBookService bookService;
	
	@RequestMapping(value = "/borrowBook", method = RequestMethod.POST)  
	@ResponseBody 
	public Map<String, Object> borrow(@RequestBody Circulation circulation,ModelMap model){
		
		Map<String, Object> map = new HashMap<String, Object>();  
		try{
		//判断读者状态，借书最大数
		int readerId2 = circulation.getReaderId();
		Reader reader = readerService.selectByPrimaryKey(readerId2);
		if(reader.getStatus()==1 && reader.getMaxBookNum()<= reader.getMaxBookNum() ){ //1:正常
			
			//判断图书状态及能否出借
			Book book = bookService.queryByBookId(circulation.getBookId());
			if(book.getIsBorrowed()!=1){//图书未借出
				
				circulation.setOperationType(1); //1:借书，2:还书，3:续借
				circulation.setContinueTimes(0);
				circulation.setStatus(1);//1 在借，2 已还，3 过期，4 图书丢失
				ReaderType readerType = readerTypeService.selectByPrimaryKey(reader.getReaderType());
				int bookLimitedDay = readerType.getBookLimitedDay();
				
				Calendar now = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String borrowDate = sdf.format(now.getTime());
				circulation.setBorrowDate(sdf.parse(borrowDate)); //当前借阅日期
				
		        now.add(Calendar.DAY_OF_MONTH, +bookLimitedDay);
		        String expectDate = sdf.format(now.getTime());
				circulation.setExpectDate(sdf.parse(expectDate));//应还日期
				
				int borrowId = service.insert(circulation); //新增一条借阅信息
				reader.setReaderBorrowbook(reader.getReaderBorrowbook()+1); //增加读者借书数
				readerService.updateByPrimaryKeySelective(reader);//更新读者信息
				
				//操作日志记录本次操作
				circulationDetail detail = new circulationDetail(); 
				detail.setBorrowId(borrowId);
				detail.setOperatedDate(new Date());
				detail.setOperationType(1);
				detail.setStaffId(circulation.getStaffId());
				circulationDetailService.insert(detail);
				
				//减少图书剩余数(图书管理模块，流通暂时不实现)
				
				map.put("success", "true");
			}
			
			
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	

}
