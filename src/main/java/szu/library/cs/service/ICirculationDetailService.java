package szu.library.cs.service;

import szu.library.cs.pojo.circulationDetail;

public interface ICirculationDetailService {
	int deleteByPrimaryKey(Integer id);

    int insert(circulationDetail record);

    int insertSelective(circulationDetail record);

    circulationDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(circulationDetail record);

    int updateByPrimaryKey(circulationDetail record);

}
