package szu.library.cs.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import szu.library.cs.dao.ReaderMapper;
import szu.library.cs.pojo.Reader;
import szu.library.cs.service.IReaderService;

@Service("readerService")
public class ReaderServiceImpl implements IReaderService{

	@Resource
	private ReaderMapper dao;
	
	public int deleteByPrimaryKey(Integer readerId) {
		return dao.deleteByPrimaryKey(readerId);
	}

	
	public int insert(Reader record) {
		return dao.insert(record);
	}

	
	public int insertSelective(Reader record) {
		return dao.insertSelective(record);
	}

	
	public Reader selectByPrimaryKey(Integer readerId) {
		return dao.selectByPrimaryKey(readerId);
	}

	
	public int updateByPrimaryKeySelective(Reader record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	
	public int updateByPrimaryKey(Reader record) {
		return dao.updateByPrimaryKey(record);
	}

	public List queryByName(String name) {
		return dao.queryByName(name);
	}
	
	public List queryByCriteria(Reader record){
		return dao.queryByCriteria(record);
	}


	@Override
	public int updateStatus(Map map) {
		// TODO Auto-generated method stub
		return dao.updateStatus(map);
	}

}
