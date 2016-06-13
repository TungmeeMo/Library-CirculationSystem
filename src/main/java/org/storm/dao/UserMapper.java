package org.storm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.storm.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	List<User> selectAll();
	//多参传值1.map<string,object>2.@Param("")3.#{1},#{2}
	List<User> login(@Param("userName") String userName,@Param("password") String password);
	int getIdByUsername(String userName);
}