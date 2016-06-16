import java.util.Date;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

import szu.library.cs.controller.ReaderController;
import szu.library.cs.pojo.Reader;
import szu.library.cs.service.IReaderService;

/**
 * 测试读者的增删改查
 * @author admin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestReader {
	
	@Resource
	private IReaderService service = null;
	
	@Resource
	private ReaderController controller;
	
	private ModelMap model = new ModelMap();
	
	@Test
	public void testNewReader(){
		Reader reader = new Reader();
		reader.setReaderName("Angel");
		reader.setReaderAddress("Shen Zhen University");
		reader.setReaderGender(2); // 1: 男  2：女
		reader.setReaderRegisterDate(new Date());
		reader.setReaderTelephone("13588854562");
		reader.setReaderType(1);
		service.insertSelective(reader);
	}
	
	@Test
	public void queryReader(){
		controller.queryById("3", model);
		Reader reader  = service.selectByPrimaryKey(1);
		System.out.println("-------------------------------------------------------");
		System.out.println(reader.getReaderId()+"; "+reader.getReaderName()+"; "+reader.getReaderAddress());
		System.out.println("-------------------------------------------------------");
	}
	
	
	@Test
	public void updateReader(){
		Reader reader1  = service.selectByPrimaryKey(1);
		reader1.setReaderAddress("Guang zhou");
		service.updateByPrimaryKeySelective(reader1);
		Reader reader  = service.selectByPrimaryKey(1);
		System.out.println("-------------------------------------------------------");
		System.out.println(reader.getReaderId()+"; "+reader.getReaderName()+"; "+reader.getReaderAddress());
		System.out.println("-------------------------------------------------------");
	}
	
	@Test
	public void deleteReader(){
		service.deleteByPrimaryKey(2);
		Reader reader = service.selectByPrimaryKey(1);
		if(reader==null){
			System.out.println("-------------------------------------------------------");
			System.out.println("delete success.");
			System.out.println("-------------------------------------------------------");
		}
	}


}
