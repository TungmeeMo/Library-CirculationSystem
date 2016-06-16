import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

import com.alibaba.fastjson.JSON;

import szu.library.cs.dao.StaffMapper;
import szu.library.cs.pojo.ReaderType;
import szu.library.cs.pojo.Staff;
import szu.library.cs.service.IReaderTypeService;
import szu.library.cs.service.IStaffService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class JunitTest {
	
	 private static Logger logger = Logger.getLogger(JunitTest.class);
	    
	    @Resource
	    private IStaffService staffService = null;
	    //--------------------------Staff---------------------------------
	    @Test
	    public void testNewStaff(){
	    	Staff staff = new Staff();
	    	staff.setUsername("admin");
	    	staff.setPassword("admin");
	    	staff.setStaffName("mo dongmei");
	        int id = staffService.insert(staff);
	        logger.info(JSON.toJSON(id));
	    }
	    
	    
		
		
		
	

}
