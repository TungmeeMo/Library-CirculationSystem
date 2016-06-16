package szu.library.cs.dao;

import szu.library.cs.pojo.circulationDetail;

public interface circulationDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(circulationDetail record);

    int insertSelective(circulationDetail record);

    circulationDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(circulationDetail record);

    int updateByPrimaryKey(circulationDetail record);
}