package szu.library.cs.dao;

import java.util.List;

import szu.library.cs.pojo.Reader;

public interface ReaderMapper {
    int deleteByPrimaryKey(Integer readerId);

    int insert(Reader record);

    int insertSelective(Reader record);

    Reader selectByPrimaryKey(Integer readerId);

    int updateByPrimaryKeySelective(Reader record);

    int updateByPrimaryKey(Reader record);
    
    List queryByName(String name);
    
    List queryByCriteria(Reader record);
    
}