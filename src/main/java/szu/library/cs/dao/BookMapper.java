package szu.library.cs.dao;

import java.util.List;

import szu.library.cs.pojo.Book;

public interface BookMapper {
    int deleteByPrimaryKey(String bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(String bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
    
    List queryByCriteria(Book book);
    
    Book queryByBookId(String name);
    
    List  getLastest5();
}