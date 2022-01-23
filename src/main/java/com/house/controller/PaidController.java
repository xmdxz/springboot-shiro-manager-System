package com.house.controller;

import com.house.service.PaidService;
import com.house.util.ResponseResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Date;

/**
 * @Author xpdxz
 * @ClassName PaidController
 * @Description TODO
 * @Date 2022/1/12 1:17
 */
@RestController
@RequestMapping(value = "/paid")
public class PaidController {

    @Resource
    private PaidService paidService;

    @GetMapping(value = "/getAllToPaid")
    public ResponseResult getAllToPaid(Integer pageNum, Integer num) {
        return ResponseResult.ok(paidService.getAllToPaid(pageNum, num));
    }

    @GetMapping(value = "/getAllToPaidCount")
    public ResponseResult getAllToPaidCount() {
        return ResponseResult.ok(paidService.getAllToPaidCount());
    }

    @GetMapping(value = "/getAllPaid")
    public ResponseResult getAllPaid(String name, Date fromDate, Date toDate, Integer pageNum, Integer num) {
        return ResponseResult.ok(paidService.getAllPaid(name, fromDate, toDate, pageNum, num));
    }

    @GetMapping(value = "/getAllPaidCount")
    public ResponseResult getAllPaidCount(String name, Date fromDate, Date toDate) {
        return ResponseResult.ok(paidService.getAllPaidCount(name, fromDate, toDate));
    }

    @DeleteMapping(value = "/deletePaid")
    public ResponseResult deletePaid(Integer id) {
        return ResponseResult.ok(paidService.deletePaid(id));
    }


}
