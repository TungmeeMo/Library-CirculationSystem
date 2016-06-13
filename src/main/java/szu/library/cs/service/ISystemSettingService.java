package szu.library.cs.service;

import szu.library.cs.pojo.SystemSetting;

public interface ISystemSettingService {
	int deleteByPrimaryKey(Integer id);

    int insert(SystemSetting record);

    int insertSelective(SystemSetting record);

    SystemSetting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemSetting record);

    int updateByPrimaryKey(SystemSetting record);
}
