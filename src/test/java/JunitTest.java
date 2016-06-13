import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;

import szu.library.cs.dao.StaffMapper;
import szu.library.cs.pojo.Staff;
import szu.library.cs.service.IStaffService;

@RunWith(SpringJUnit4ClassRunner.class) //表示继承自SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class JunitTest {
	
	 private static Logger logger = Logger.getLogger(JunitTest.class);
	    
	    @Resource
	    private IStaffService staffService = null;
	    
	    @Resource
	    private StaffMapper dao = null;
	    
	    @Test
	    public void test1(){
	    	Staff staff = new Staff();
	    	staff.setUsername("admin");
	    	staff.setPassword("admin");
	    	staff.setStaffName("mo dongmei");
	        int id = staffService.insert(staff);
	        logger.info(JSON.toJSON(id));
	    }
	    
	    
	    
//	    @Test
//	    public void test2(){
//	    	Staff staff  = staffService.selectByPrimaryKey(2);
//	    	staff.setStaffName("mo");
//	    	staffService.updateByPrimaryKeySelective(staff);
//	        logger.info(JSON.toJSON(staff));
//	    }
	    
	    
	    //  @Before  
	    // 没有spring时候，需要手动加载服务
	    //  public void before() {  
//	          ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//	          userService = (IUserService) ac.getBean("userService");  
	    //  }
	

}
