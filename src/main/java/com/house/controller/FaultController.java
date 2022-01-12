package com.house.controller;

import com.house.pojo.Wrong;
import com.house.service.FaultService;
import com.house.util.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Date;

/**
 * @Author xpdxz
 * @ClassName FaultController
 * @Description TODO
 * @Date 2022/1/12 1:11
 */

@RestController
@RequestMapping(value = "/fault")
public class FaultController {

    @Resource
    private FaultService faultService;

    @GetMapping(value = "/getAllFault")
    public ResponseResult getAllFault(Integer pageNum, Integer num) {
        return ResponseResult.ok(faultService.getAllFault(pageNum, num));
    }

    @GetMapping(value = "/addWrong")
    public ResponseResult addWrong(Wrong wrong) {
        return ResponseResult.ok(faultService.addWrong(wrong));
    }

    @GetMapping(value = "/getFaultCount")
    public ResponseResult getFaultCount() {
        return ResponseResult.ok(faultService.getFaultCount());
    }

    @GetMapping(value = "/agreeSolve")
    public ResponseResult agreeSolve(Integer id) {
        return ResponseResult.ok(faultService.agreeSolve(id));
    }

    @GetMapping(value = "/getSolves")
    public ResponseResult getSolves(String name, Date fromDate, Date toDate, Integer pageNum, Integer num) {
        return ResponseResult.ok(faultService.getSolves(name, fromDate, toDate, pageNum, num));
    }

    @GetMapping(value = "/getSolveCount")
    public ResponseResult getSolvesCount(String name, Date fromDate, Date toDate) {
        return ResponseResult.ok(faultService.getSolvesCount(name, fromDate, toDate));
    }

    @GetMapping(value = "/getZuSolves")
    public ResponseResult getZuSolves(String name, Date fromDate, Date toDate, Integer pageNum, Integer num) {
        return ResponseResult.ok(faultService.getZuSolves(name, fromDate, toDate, pageNum, num));
    }

    @GetMapping(value = "/getZuSolveCount")
    public ResponseResult getZuSolvesCount(String name, Date fromDate, Date toDate) {
        return ResponseResult.ok(faultService.getZuSolvesCount(name, fromDate, toDate));
    }

    @GetMapping(value = "/deleteSolve")
    public ResponseResult deleteSolve(Integer id) {
        return ResponseResult.ok(faultService.deleteSolve(id));
    }
}
