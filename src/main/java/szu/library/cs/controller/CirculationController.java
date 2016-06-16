package szu.library.cs.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
	public Map<String, Object> borrow(@RequestBody  JSONObject jsonObj,ModelMap model){
		System.out.println(jsonObj);
//		int size = params.size();
//		for(int i=0;i<params.size();i++){
//			Map<String,Object> map = params.get(i);
//			int readerId = (Integer) map.get("readerId");
//		}
		
		return null;
//		
//		Circulation circulation = new Circulation();
//		circulation.setStaffId(Integer.parseInt(staffId));
//		circulation.setBookId(bookId);
//		circulation.setReaderId(Integer.parseInt(readerId));
//		Map<String, Object> map = new HashMap<String, Object>();  
//		
//		//判断读者状态，借书最大数
//		int readerId2 = circulation.getReaderId();
//		Reader reader = readerService.selectByPrimaryKey(readerId2);
//		if(reader.getStatus()==1 && reader.getMaxBookNum()<= reader.getMaxBookNum() ){ //1:正常
//			
//			//判断图书状态及能否出借
//			Book book = bookService.queryByBookId(circulation.getBookId());
//			if(book.getIsBorrowed()!=1){//图书未借出
//				
//				circulation.setOperationType(1); //1:借书，2:还书，3:续借
//				circulation.setStatus(1);//1 在借，2 已还，3 过期，4 图书丢失
//				ReaderType readerType = readerTypeService.selectByPrimaryKey(reader.getReaderType());
//				int bookLimitedDay = readerType.getBookLimitedDay();
//				
//				Calendar now = Calendar.getInstance();
//				String borrowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.getTime());
//				circulation.setBorrowDate(new Date(borrowDate)); //当前借阅日期
//				
//		        now.add(Calendar.DAY_OF_MONTH, +bookLimitedDay);
//		        String expectDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.getTime());
//				circulation.setExpectDate(new Date(expectDate));//应还日期
//				
//				int borrowId = service.insert(circulation); //新增一条借阅信息
//				reader.setReaderBorrowbook(reader.getMaxBookNum()+1); //增加读者借书数
//				
//				//操作日志记录本次操作
//				circulationDetail detail = new circulationDetail(); 
//				detail.setBorrowId(borrowId);
//				detail.setOperatedDate(new Date());
//				detail.setOperationType(1);
//				detail.setStaffId(circulation.getStaffId());
//				circulationDetailService.insert(detail);
//				
//				//减少图书剩余数(图书管理模块，流通暂时不实现)
//			}
//		}
//		return map;
	}
	
	

}
