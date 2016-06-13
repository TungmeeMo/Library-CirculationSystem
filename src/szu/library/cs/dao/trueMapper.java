package szu.library.cs.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import szu.library.cs.pojo.true;
import szu.library.cs.pojo.trueExample;

public interface trueMapper {
    int countByExample(trueExample example);

    int deleteByExample(trueExample example);

    int deleteByPrimaryKey(Integer staffId);

    int insert(true record);

    int insertSelective(true record);

    List<true> selectByExample(trueExample example);

    true selectByPrimaryKey(Integer staffId);

    int updateByExampleSelective(@Param("record") true record, @Param("example") trueExample example);

    int updateByExample(@Param("record") true record, @Param("example") trueExample example);

    int updateByPrimaryKeySelective(true record);

    int updateByPrimaryKey(true record);
}