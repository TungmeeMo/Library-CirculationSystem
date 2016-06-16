package szu.library.cs.service;

import java.util.List;

import szu.library.cs.pojo.BookType;

public interface IBookTypeService {
	
	int deleteByPrimaryKey(String typeId);

    int insert(BookType record);

    int insertSelective(BookType record);

    BookType selectByPrimaryKey(String typeId);

    int updateByPrimaryKeySelective(BookType record);

    int updateByPrimaryKey(BookType record);
    
    BookType queryByName(String name);
}
