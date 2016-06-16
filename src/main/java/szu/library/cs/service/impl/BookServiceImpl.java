package szu.library.cs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import szu.library.cs.dao.BookMapper;
import szu.library.cs.dao.BookTypeMapper;
import szu.library.cs.pojo.Book;
import szu.library.cs.service.IBookService;

@Service("bookService")
public class BookServiceImpl implements IBookService {

	@Resource
	private BookMapper dao;
	
	public int deleteByPrimaryKey(String bookId) {
		return dao.deleteByPrimaryKey(bookId);
	}

	
	public int insert(Book record) {
		return dao.insert(record);
	}

	
	public int insertSelective(Book record) {
		return dao.insertSelective(record);
	}

	
	public Book selectByPrimaryKey(String bookId) {
		return dao.selectByPrimaryKey(bookId);
	}

	
	public int updateByPrimaryKeySelective(Book record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	
	public int updateByPrimaryKey(Book record) {
		return dao.updateByPrimaryKey(record);
	}

	
	public List queryByCriteria(Book book) {
		return dao.queryByCriteria(book);
	}
	
	public Book queryByBookId(String name){
		return dao.queryByBookId(name);
	}

}
