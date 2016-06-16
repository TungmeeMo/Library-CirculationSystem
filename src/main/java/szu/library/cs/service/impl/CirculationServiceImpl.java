package szu.library.cs.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import szu.library.cs.dao.CirculationMapper;
import szu.library.cs.pojo.Circulation;
import szu.library.cs.service.ICirculationService;

@Service("circulationService")
public class CirculationServiceImpl implements ICirculationService {

	@Resource
	private CirculationMapper dao;
	public int deleteByPrimaryKey(Integer borrowId) {
		return dao.deleteByPrimaryKey(borrowId);
	}

	
	public int insert(Circulation record) {
		return dao.insert(record);
	}
	
	public Circulation selectByPrimaryKey(Integer borrowId) {
		return dao.selectByPrimaryKey(borrowId);
	}

	
	public int updateByPrimaryKeySelective(Circulation record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	
	public int updateByPrimaryKey(Circulation record) {
		return dao.updateByPrimaryKey(record);
	}


	public int insertSelective(Circulation record) {
		return dao.insertSelective(record);
	}

}
