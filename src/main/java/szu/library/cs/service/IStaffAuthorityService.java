package szu.library.cs.service;

import java.util.List;

import szu.library.cs.pojo.StaffAuthority;

public interface IStaffAuthorityService {
	
	int deleteByPrimaryKey(Integer authorityId);
	
	int insert(StaffAuthority record);
	
	int insertSelective(StaffAuthority record);
	
	StaffAuthority selectByPrimaryKey(Integer authorityId);
	
	int updateByPrimaryKeySelective(StaffAuthority record);
	
	int updateByPrimaryKey(StaffAuthority record);
	
	List getAll(); //��ѯ���еļ�¼
	
	StaffAuthority queryByName(String name);
}
