package com.house.controller;

import com.house.pojo.Schedule;
import com.house.service.ScheduleService;
import com.house.util.ResponseResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author xpdxz
 * @ClassName ScheduleController
 * @Description TODO
 * @Date 2022/1/12 1:21
 */

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

    @Resource
    private ScheduleService scheduleService;

    @GetMapping(value = "/getSchedules")
    public ResponseResult getSchedules(Integer pageNum, Integer num) {
        return ResponseResult.ok(scheduleService.getSchedules(pageNum, num));
    }

    @GetMapping(value = "/getScheduleCount")
    public ResponseResult getScheduleCount() {
        return ResponseResult.ok(scheduleService.getScheduleCount());
    }

    @DeleteMapping(value = "/deleteSchedule")
    public ResponseResult deleteSchedule(Integer id) {
        return ResponseResult.ok(scheduleService.deleteSchedule(id));
    }

    @GetMapping(value = "/getSchedule")
    public ResponseResult getSchedule(Integer id) {
        return ResponseResult.ok(scheduleService.getSchedule(id));
    }

    @GetMapping(value = "/updateSchedule")
    public ResponseResult updateSchedule(Schedule schedule) {
        return ResponseResult.ok(scheduleService.updateSchedule(schedule));
    }

    @GetMapping(value = "/addSchedule")
    public ResponseResult addSchedule(Schedule schedule) {
        return ResponseResult.ok(scheduleService.addSchedule(schedule));
    }


}
