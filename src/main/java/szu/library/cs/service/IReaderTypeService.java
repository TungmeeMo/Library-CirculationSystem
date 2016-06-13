package szu.library.cs.service;

import java.util.List;

import szu.library.cs.pojo.ReaderType;

public interface IReaderTypeService {
	
	int deleteByPrimaryKey(Integer typeId);
	
	int insert(ReaderType record);
	
	int insertSelective(ReaderType record);
	
	ReaderType selectByPrimaryKey(Integer typeId);
	
	int updateByPrimaryKeySelective(ReaderType record);
	
	int updateByPrimaryKey(ReaderType record);
	
	List getAll();
	
	ReaderType queryByName(String name);

}
