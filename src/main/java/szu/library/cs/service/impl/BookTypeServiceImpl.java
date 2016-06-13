package szu.library.cs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import szu.library.cs.dao.BookTypeMapper;
import szu.library.cs.pojo.BookType;
import szu.library.cs.service.IBookTypeService;

@Service("bookTypeService")
public class BookTypeServiceImpl implements IBookTypeService{

	@Resource
	private BookTypeMapper dao;
	public int deleteByPrimaryKey(Integer typeId) {
		return dao.deleteByPrimaryKey(typeId);
	}

	
	public int insert(BookType record) {
		return dao.insert(record);
	}

	
	public int insertSelective(BookType record) {
		return dao.insertSelective(record);
	}

	
	public BookType selectByPrimaryKey(Integer typeId) {
		return dao.selectByPrimaryKey(typeId);
	}

	
	public int updateByPrimaryKeySelective(BookType record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	
	public int updateByPrimaryKey(BookType record) {
		return dao.updateByPrimaryKey(record);
	}
	
	public BookType queryByName(String name){
		return dao.queryByName(name);
	}

}
