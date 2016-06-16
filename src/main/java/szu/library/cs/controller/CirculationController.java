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
//		//�ж϶���״̬�����������
//		int readerId2 = circulation.getReaderId();
//		Reader reader = readerService.selectByPrimaryKey(readerId2);
//		if(reader.getStatus()==1 && reader.getMaxBookNum()<= reader.getMaxBookNum() ){ //1:����
//			
//			//�ж�ͼ��״̬���ܷ����
//			Book book = bookService.queryByBookId(circulation.getBookId());
//			if(book.getIsBorrowed()!=1){//ͼ��δ���
//				
//				circulation.setOperationType(1); //1:���飬2:���飬3:����
//				circulation.setStatus(1);//1 �ڽ裬2 �ѻ���3 ���ڣ�4 ͼ�鶪ʧ
//				ReaderType readerType = readerTypeService.selectByPrimaryKey(reader.getReaderType());
//				int bookLimitedDay = readerType.getBookLimitedDay();
//				
//				Calendar now = Calendar.getInstance();
//				String borrowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.getTime());
//				circulation.setBorrowDate(new Date(borrowDate)); //��ǰ��������
//				
//		        now.add(Calendar.DAY_OF_MONTH, +bookLimitedDay);
//		        String expectDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.getTime());
//				circulation.setExpectDate(new Date(expectDate));//Ӧ������
//				
//				int borrowId = service.insert(circulation); //����һ��������Ϣ
//				reader.setReaderBorrowbook(reader.getMaxBookNum()+1); //���Ӷ��߽�����
//				
//				//������־��¼���β���
//				circulationDetail detail = new circulationDetail(); 
//				detail.setBorrowId(borrowId);
//				detail.setOperatedDate(new Date());
//				detail.setOperationType(1);
//				detail.setStaffId(circulation.getStaffId());
//				circulationDetailService.insert(detail);
//				
//				//����ͼ��ʣ����(ͼ�����ģ�飬��ͨ��ʱ��ʵ��)
//			}
//		}
//		return map;
	}
	
	

}
