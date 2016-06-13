package szu.library.cs.service;

import java.util.List;

import szu.library.cs.pojo.BookType;

public interface IBookTypeService {
	
	int deleteByPrimaryKey(Integer typeId);

    int insert(BookType record);

    int insertSelective(BookType record);

    BookType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(BookType record);

    int updateByPrimaryKey(BookType record);
    
    BookType queryByName(String name);
}
