package com.house.dao;

import com.house.pojo.Schedule;

import java.util.List;

/**
 * @Author xpdxz
 * @ClassName ScheduleDao
 * @Description TODO
 * @Date 2022/1/12 1:44
 */
public interface ScheduleDao {

    List<Schedule> getSchedules();

    Integer getScheduleCount();

    Integer deleteSchedule(Integer id);

    Schedule getSchedule(Integer id);

    Integer updateSchedule(Schedule schedule);

    Integer addSchedule(Schedule schedule);
}
