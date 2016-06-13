package szu.library.cs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import szu.library.cs.dao.ReaderTypeMapper;
import szu.library.cs.pojo.ReaderType;
import szu.library.cs.service.IReaderTypeService;

@Service("readerTypeService")
public class ReaderTypeServiceImpl implements IReaderTypeService {

	@Resource
	private ReaderTypeMapper dao;
	
	public int deleteByPrimaryKey(Integer typeId) {
		return dao.deleteByPrimaryKey(typeId);
	}

	
	public int insert(ReaderType record) {
		return dao.insert(record);
	}

	
	public int insertSelective(ReaderType record) {
		return dao.insertSelective(record);
	}

	
	public ReaderType selectByPrimaryKey(Integer typeId) {
		return dao.selectByPrimaryKey(typeId);
	}

	
	public int updateByPrimaryKeySelective(ReaderType record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	
	public int updateByPrimaryKey(ReaderType record) {
		return dao.updateByPrimaryKey(record);
	}

	
	public List getAll() {
		return dao.getAll();
	}
	
	public ReaderType queryByName(String name){
		return dao.queryByName(name);
	}

}
