package szu.library.cs.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import szu.library.cs.dao.BookTypeMapper;
import szu.library.cs.dao.circulationDetailMapper;
import szu.library.cs.pojo.circulationDetail;
import szu.library.cs.service.ICirculationDetailService;

@Service("circulationDetailService")
public class CirculationDetailServiceImpl implements ICirculationDetailService {

	@Resource
	private circulationDetailMapper dao;
	public int deleteByPrimaryKey(Integer id) {
		return dao.deleteByPrimaryKey(id);
	}

	
	public int insert(circulationDetail record) {
		return dao.insert(record);
	}

	
	public int insertSelective(circulationDetail record) {
		return dao.insertSelective(record);
	}

	
	public circulationDetail selectByPrimaryKey(Integer id) {
		return dao.selectByPrimaryKey(id);
	}

	
	public int updateByPrimaryKeySelective(circulationDetail record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	
	public int updateByPrimaryKey(circulationDetail record) {
		return dao.updateByPrimaryKey(record);
	}

}
