package com.house.service;

import com.house.pojo.Schedule;

import java.util.List;

/**
 * @Author xpdxz
 * @ClassName ScheduleService
 * @Description TODO
 * @Date 2022/1/12 1:31
 */
public interface ScheduleService {
    List<Schedule> getSchedules(Integer pageNum, Integer num);

    Integer getScheduleCount();

    Integer deleteSchedule(Integer id);

    Schedule getSchedule(Integer id);

    Integer updateSchedule(Schedule schedule);

    Integer addSchedule(Schedule schedule);
}
