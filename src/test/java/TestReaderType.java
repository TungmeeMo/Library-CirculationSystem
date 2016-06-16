import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

import szu.library.cs.controller.ReaderTypeController;
import szu.library.cs.pojo.ReaderType;
import szu.library.cs.service.IReaderTypeService;

/**
 * 测试读者类型的增删改查
 * @author admin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestReaderType {
	@Resource
    private IReaderTypeService readerTypeService;
	
	@Resource
	private ReaderTypeController controller;
	
	@Test
	public void testNewReaderType(){
		ModelMap model = new ModelMap();
		
		ReaderType type = new ReaderType();
		type.setTypeName("学生");
		type.setBookLimitedDay(60); //借书期限 天
		type.setBookMaxmum(5); //借书最大本数
		type.setValidPeriod(2*365); //读者类型有效期 天
//		readerTypeService.insertSelective(type);
		controller.newReaderType(type, model);
		
		
		ReaderType type2 = new ReaderType();
		type2.setTypeName("教师");
		type2.setBookLimitedDay(90); //借书期限 天
		type2.setBookMaxmum(10); //借书最大本数
		type2.setValidPeriod(3*365); //读者类型有效期 天
//		readerTypeService.insertSelective(type2);
		controller.newReaderType(type2, model);
		
		ReaderType type3 = new ReaderType();
		type3.setTypeName("外来人员");
		type3.setBookLimitedDay(30); //借书期限 天
		type3.setBookMaxmum(5); //借书最大本数
		type3.setValidPeriod(90); //读者类型有效期 天
//		readerTypeService.insertSelective(type3);
		controller.newReaderType(type3, model);
	}
	
	@Test
	public void query(){
		ReaderType type = readerTypeService.selectByPrimaryKey(1);
		System.out.println("-------------------------------------------------------");
		System.out.println(type.getTypeId()+";"+type.getTypeName());
		System.out.println("-------------------------------------------------------");
	}

}
