package szu.library.cs.dao;

import java.util.List;

import szu.library.cs.pojo.Staff;

public interface StaffMapper {

    int deleteByPrimaryKey(Integer staffId);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer staffId);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
    
    Staff getByUsername(String username);
    
    List getAll();
    
    List queryByName(String name);
    
}