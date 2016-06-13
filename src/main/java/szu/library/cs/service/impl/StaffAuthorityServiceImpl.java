package szu.library.cs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import szu.library.cs.dao.StaffAuthorityMapper;
import szu.library.cs.pojo.StaffAuthority;
import szu.library.cs.service.IStaffAuthorityService;

@Service("staffAuthorityService")
public class StaffAuthorityServiceImpl implements IStaffAuthorityService {

	@Resource
	private StaffAuthorityMapper dao;
	
	public int deleteByPrimaryKey(Integer authorityId) {
		return dao.deleteByPrimaryKey(authorityId);
	}

	
	public int insert(StaffAuthority record) {
		return dao.insert(record);
	}

	
	public int insertSelective(StaffAuthority record) {
		return dao.insertSelective(record);
	}

	
	public StaffAuthority selectByPrimaryKey(Integer authorityId) {
		return dao.selectByPrimaryKey(authorityId);
	}

	
	public int updateByPrimaryKeySelective(StaffAuthority record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	
	public int updateByPrimaryKey(StaffAuthority record) {
		return dao.updateByPrimaryKey(record);
	}

	public List getAll() {
		return dao.getAll();
	}
	
	public StaffAuthority queryByName(String name){
		return dao.queryByName(name);
	}

}
