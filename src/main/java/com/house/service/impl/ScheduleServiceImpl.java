package com.house.service.impl;

import com.github.pagehelper.page.PageMethod;
import com.house.dao.ScheduleDao;
import com.house.pojo.Schedule;
import com.house.service.ScheduleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author xpdxz
 * @ClassName ScheduleServiceImpl
 * @Description TODO
 * @Date 2022/1/12 1:42
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Resource
    private ScheduleDao scheduleDao;

    @Override
    public List<Schedule> getSchedules(Integer pageNum, Integer num) {
        PageMethod.startPage(pageNum, num);
        return scheduleDao.getSchedules();
    }

    @Override
    public Integer getScheduleCount() {
        return scheduleDao.getScheduleCount();
    }

    @Override
    public Integer deleteSchedule(Integer id) {
        return scheduleDao.deleteSchedule(id);
    }

    @Override
    public Schedule getSchedule(Integer id) {
        return scheduleDao.getSchedule(id);
    }

    @Override
    public Integer updateSchedule(Schedule schedule) {
        return scheduleDao.updateSchedule(schedule);
    }

    @Override
    public Integer addSchedule(Schedule schedule) {
        return scheduleDao.addSchedule(schedule);
    }
}
