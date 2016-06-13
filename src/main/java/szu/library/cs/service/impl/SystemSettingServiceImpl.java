package szu.library.cs.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import szu.library.cs.dao.StaffMapper;
import szu.library.cs.dao.SystemSettingMapper;
import szu.library.cs.pojo.SystemSetting;
import szu.library.cs.service.ISystemSettingService;

@Service("systemSettingService")
public class SystemSettingServiceImpl implements ISystemSettingService {

	@Resource
	private SystemSettingMapper dao;
	public int deleteByPrimaryKey(Integer id) {
		return dao.deleteByPrimaryKey(id);
	}

	
	public int insert(SystemSetting record) {
		return dao.insert(record);
	}

	
	public int insertSelective(SystemSetting record) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public SystemSetting selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int updateByPrimaryKeySelective(SystemSetting record) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int updateByPrimaryKey(SystemSetting record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
