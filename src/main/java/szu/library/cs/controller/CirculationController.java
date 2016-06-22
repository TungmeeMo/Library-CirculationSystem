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
		//�ж϶���״̬�����������
		int readerId2 = circulation.getReaderId();
		Reader reader = readerService.selectByPrimaryKey(readerId2);
		if(reader.getStatus()==1 && reader.getMaxBookNum()<= reader.getMaxBookNum() ){ //1:����
			
			//�ж�ͼ��״̬���ܷ����
			Book book = bookService.queryByBookId(circulation.getBookId());
			if(book.getIsBorrowed()!=1){//ͼ��δ���
				
				circulation.setOperationType(1); //1:���飬2:���飬3:����
				circulation.setContinueTimes(0);
				circulation.setStatus(1);//1 �ڽ裬2 �ѻ���3 ���ڣ�4 ͼ�鶪ʧ
				ReaderType readerType = readerTypeService.selectByPrimaryKey(reader.getReaderType());
				int bookLimitedDay = readerType.getBookLimitedDay();
				
				Calendar now = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String borrowDate = sdf.format(now.getTime());
				circulation.setBorrowDate(sdf.parse(borrowDate)); //��ǰ��������
				
		        now.add(Calendar.DAY_OF_MONTH, +bookLimitedDay);
		        String expectDate = sdf.format(now.getTime());
				circulation.setExpectDate(sdf.parse(expectDate));//Ӧ������
				
				int borrowId = service.insert(circulation); //����һ��������Ϣ
				reader.setReaderBorrowbook(reader.getReaderBorrowbook()+1); //���Ӷ��߽�����
				readerService.updateByPrimaryKeySelective(reader);//���¶�����Ϣ
				
				book.setIsBorrowed(1); //����ͼ��Ϊ�ѽ��
				bookService.updateByPrimaryKeySelective(book); //����ͼ����Ϣ
				
				
				//������־��¼���β���
				circulationDetail detail = new circulationDetail(); 
				detail.setBorrowId(borrowId);
				detail.setOperatedDate(new Date());
				detail.setOperationType(1);
				detail.setStaffId(circulation.getStaffId());
				circulationDetailService.insert(detail);
				
				//����ͼ��ʣ����(ͼ�����ģ�飬��ͨ��ʱ��ʵ��)
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
//		����Ҫ����һ����ͼ��Ӧ��ʵ����
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
			Circulation circulation = service.getCirculationForReturn(bookId,1); //status 1: �ڽ衣��ʾ��δ��
			if(null != circulation){
			
				//�޸ĵ�ǰ���ļ�¼
				Calendar now = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String returnDate = sdf.format(now.getTime());
				circulation.setReturnDate(sdf.parse(returnDate)); //���û�������
				circulation.setOperationType(2);//���ò������ͣ�����
				circulation.setStatus(2);//����״̬:�ѻ�
				service.updateByPrimaryKeySelective(circulation);
				ReaderCirculation readercirculation = readerCirculationService.getByBorrowId(circulation.getBorrowId());
				
				//�޸�ͼ��
				Book book = bookService.selectByPrimaryKey(bookId);
				book.setIsBorrowed(0); //���õ�ǰͼ���isBorrowed=0
				bookService.updateByPrimaryKeySelective(book);
				
				//�޸Ķ���
				int readerId = circulation.getReaderId();
				Reader reader = readerService.selectByPrimaryKey(readerId);
				reader.setReaderBorrowbook(reader.getReaderBorrowbook()-1);//���ö����ѽ�ͼ����-1
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
