package szu.library.cs.dao;

import java.util.List;

import szu.library.cs.pojo.StaffAuthority;

public interface StaffAuthorityMapper {
    int deleteByPrimaryKey(Integer authorityId);

    int insert(StaffAuthority record);

    int insertSelective(StaffAuthority record);

    StaffAuthority selectByPrimaryKey(Integer authorityId);

    int updateByPrimaryKeySelective(StaffAuthority record);

    int updateByPrimaryKey(StaffAuthority record);
    
    List getAll();
    
    StaffAuthority queryByName(String name);
}