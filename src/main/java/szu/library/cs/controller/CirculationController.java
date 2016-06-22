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
import szu.library.cs.pojo.ReaderCirculation;
import szu.library.cs.pojo.ReaderType;
import szu.library.cs.pojo.circulationDetail;
import szu.library.cs.service.IBookService;
import szu.library.cs.service.ICirculationDetailService;
import szu.library.cs.service.ICirculationService;
import szu.library.cs.service.IReaderCirculationService;
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
	
	@Resource
	private IReaderCirculationService readerCirculationService;
	
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
				
				book.setIsBorrowed(1); //设置图书为已借出
				bookService.updateByPrimaryKeySelective(book); //更新图书信息
				
				
				//操作日志记录本次操作
				circulationDetail detail = new circulationDetail(); 
				detail.setBorrowId(borrowId);
				detail.setOperatedDate(new Date());
				detail.setOperationType(1);
				detail.setStaffId(circulation.getStaffId());
				circulationDetailService.insert(detail);
				
				//减少图书剩余数(图书管理模块，流通暂时不实现)
				map.put("success", "true");
			}else{
				map.put("success", "false");
			}
			
			
		}else{
			map.put("success", "false");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
//	@RequestMapping(value = "/getCirculationByBookId", method = RequestMethod.POST)  
//	@ResponseBody 
//	public Map<String, Object> getCirculationByBookId(@RequestBody String bookId){
//		Map<String, Object> map = new HashMap<String, Object>();  
//		try{
//			Circulation cir = service.getCirculationByBookId(Integer.parseInt(bookId));
//		map.put("sucess", "true");
//		还需要建立一个视图对应的实体类
//		map.put("bookList", cir);
//		}catch(Exception e){
//			e.printStackTrace();
//			map.put("sucess", "false");
//		}
//		return map;
//	}
	
	@RequestMapping(value = "/returnBook", method = RequestMethod.GET)  
	@ResponseBody 
	public Map<String, Object> returnBook( String bookId){
		Map<String, Object> map = new HashMap<String, Object>();  
		try{
			if("".equals(bookId) || null == bookId){
				map.put("success", "false");
				return map;
			}
			Circulation circulation = service.getCirculationForReturn(bookId,1); //status 1: 在借。表示书未还
			if(null != circulation){
			
				//修改当前借阅记录
				Calendar now = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String returnDate = sdf.format(now.getTime());
				circulation.setReturnDate(sdf.parse(returnDate)); //设置还书日期
				circulation.setOperationType(2);//设置操作类型：还书
				circulation.setStatus(2);//设置状态:已还
				service.updateByPrimaryKeySelective(circulation);
				ReaderCirculation readercirculation = readerCirculationService.getByBorrowId(circulation.getBorrowId());
				
				//修改图书
				Book book = bookService.selectByPrimaryKey(bookId);
				book.setIsBorrowed(0); //设置当前图书的isBorrowed=0
				bookService.updateByPrimaryKeySelective(book);
				
				//修改读者
				int readerId = circulation.getReaderId();
				Reader reader = readerService.selectByPrimaryKey(readerId);
				reader.setReaderBorrowbook(reader.getReaderBorrowbook()-1);//设置读者已借图书数-1
				readerService.updateByPrimaryKeySelective(reader);
				
				map.put("success", "true");
				map.put("reader", reader);
				map.put("readercirculation", readercirculation);
				
			}else{
				map.put("success", "false");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", "false");
		}
		return map;
	}
	
	
	
	
	

}
