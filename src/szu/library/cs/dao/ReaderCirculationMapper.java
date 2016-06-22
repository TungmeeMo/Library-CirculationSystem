package szu.library.cs.dao;

import szu.library.cs.pojo.ReaderCirculation;

public interface ReaderCirculationMapper {
    int insert(ReaderCirculation record);

    int insertSelective(ReaderCirculation record);
}