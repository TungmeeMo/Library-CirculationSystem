package szu.library.cs.dao;

import szu.library.cs.pojo.UserSetting;

public interface UserSettingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserSetting record);

    int insertSelective(UserSetting record);

    UserSetting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserSetting record);

    int updateByPrimaryKey(UserSetting record);
}