import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import szu.library.cs.pojo.BookType;
import szu.library.cs.pojo.ReaderType;
import szu.library.cs.service.IBookService;
import szu.library.cs.service.IBookTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestBookType {
	
	@Resource
	private IBookTypeService service;
	
	@Test
	public void testNewBookType(){
		BookType type = new BookType();
		type.setTypeName("经济");
		type.setTypeId("J0001");
		type.setCode("J000101");
		type.setDocumentType("中文图书");
		service.insertSelective(type);
		
		
		type.setTypeName("政治");
		type.setTypeId("J0002");
		type.setCode("J000102");
		type.setDocumentType("中文图书");
		service.insertSelective(type);
		
//		type.setTypeName("文学");
//		type.setTypeName("生物");
//		type.setTypeName("地理");
//		type.setTypeName("艺术");
//		type.setTypeName("工业技术");
//		type.setTypeName("自然科学总论");
		
	}
	
	@Test
	public void query(){
		BookType type = service.selectByPrimaryKey("J0001");
		System.out.println("-------------------------------------------------------");
		System.out.println(type.getTypeId()+";"+type.getTypeName());
		System.out.println("-------------------------------------------------------");
	}
	
	@Test
	public void delete(){
		service.deleteByPrimaryKey("J0002");
	}
	
	@Test
	public void update(){
		BookType type = service.selectByPrimaryKey("J0001");
		type.setPlace("Shen Zhen");
		service.updateByPrimaryKey(type);
	}

}
