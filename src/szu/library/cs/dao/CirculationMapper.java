package szu.library.cs.dao;

import szu.library.cs.pojo.Circulation;

public interface CirculationMapper {
    int deleteByPrimaryKey(Integer borrowId);

    int insert(Circulation record);

    int insertSelective(Circulation record);

    Circulation selectByPrimaryKey(Integer borrowId);

    int updateByPrimaryKeySelective(Circulation record);

    int updateByPrimaryKey(Circulation record);
}