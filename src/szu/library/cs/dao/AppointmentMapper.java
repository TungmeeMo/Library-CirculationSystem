package szu.library.cs.dao;

import szu.library.cs.pojo.Appointment;

public interface AppointmentMapper {
    int deleteByPrimaryKey(Integer appointmentId);

    int insert(Appointment record);

    int insertSelective(Appointment record);

    Appointment selectByPrimaryKey(Integer appointmentId);

    int updateByPrimaryKeySelective(Appointment record);

    int updateByPrimaryKey(Appointment record);
}