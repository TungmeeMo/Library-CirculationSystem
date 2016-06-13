package szu.library.cs.service;

import java.util.List;

import szu.library.cs.pojo.Book;

public interface IBookService {
	int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
    
    List queryByCriteria(Book book);

}
