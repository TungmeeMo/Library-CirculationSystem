import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

import szu.library.cs.controller.BookController;
import szu.library.cs.pojo.Book;
import szu.library.cs.pojo.BookType;
import szu.library.cs.service.IBookService;
import szu.library.cs.service.IBookTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestBook {
	
	@Resource
	private IBookService service;
	@Resource
	private IBookTypeService typeService;
	@Resource
	private BookController bookController;
	
	private ModelMap model = new ModelMap();
	
	@Test
	public void testNew(){
		Book book = new Book();
		BookType type = typeService.selectByPrimaryKey("J0001");
		book.setTypeId(type.getTypeId());
		book.setBookId(type.getTypeId()+"001");
		book.setBookName("高级软件工程");
		book.setAuthorName("邓迎春 韩松");
		book.setIsBorrowed(0);
		book.setReaderRegisterDate(new Date());
		bookController.newBook(book, model);
	}
	
	@Test
	public void testQuery(){
		Book book = service.queryByBookId("J0001001");
		System.out.println("-------------------------------------------------------");
		System.out.println(book.getTypeId()+";"+book.getBookName()+";"+book.getAuthorName());
		System.out.println("-------------------------------------------------------");
	}
	
	@Test
	public void tesUpdate(){
		Book book = service.queryByBookId("J0001001");
		book.setBookName("高级软件工程 第二版");
		bookController.update(book, model);
		System.out.println("-------------------------------------------------------");
		System.out.println(book.getTypeId()+";"+book.getBookName()+";"+book.getAuthorName());
		System.out.println("-------------------------------------------------------");
	}
	
	@Test
	public void testqueryById(){
		bookController.queryById("J0001001", model);
	}

}
