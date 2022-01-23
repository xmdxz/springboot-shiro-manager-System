package com.house.controller;

import com.house.service.ApplyService;
import com.house.util.ResponseResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author xpdxz
 * @ClassName ApplyController
 * @Description TODO
 * @Date 2022/1/12 1:03
 */
@RestController
@RequestMapping(value = "/apply")
public class ApplyController {

    @Resource
    private ApplyService applyService;

    @GetMapping(value = "/getAllApply")
    public ResponseResult getAllApply(Integer pageNum, Integer num) {
        return ResponseResult.ok(applyService.getAllApply(pageNum, num));
    }

    @GetMapping(value = "/getApplyCount")
    public ResponseResult getApplyCount() {
        return ResponseResult.ok(applyService.getApplyCount());
    }

    @GetMapping(value = "/agreeApply")
    public ResponseResult agreeApply(Integer id, String houseId) {
        return ResponseResult.ok(applyService.agreeApply(id, houseId));
    }

    @GetMapping(value = "/refuseApply")
    public ResponseResult refuseApply(Integer id, String houseId) {
        return ResponseResult.ok(applyService.refuseApply(id, houseId));
    }

    @GetMapping(value = "/getAllApplyOut")
    public ResponseResult getAllApplyOut(Integer pageNum, Integer num) {
        return ResponseResult.ok(applyService.getAllApplyOut(pageNum, num));
    }

    @GetMapping(value = "/getApplyOutCount")
    public ResponseResult getApplyOutCount() {
        return ResponseResult.ok(applyService.getApplyOutCount());
    }

    @GetMapping(value = "/agreeApplyOut")
    public ResponseResult agreeApplyOut(Integer id, String houseId) {
        return ResponseResult.ok(applyService.agreeApplyOut(id, houseId));
    }

    @GetMapping(value = "/refuseApplyOut")
    public ResponseResult refuseApplyOut(Integer id, String houseId) {
        return ResponseResult.ok(applyService.refuseApplyOut(id, houseId));
    }

    @GetMapping(value = "/getZuAllApply")
    public ResponseResult getZuAllApply(Integer pageNum, Integer num) {
        return ResponseResult.ok(applyService.getZuAllApply(pageNum, num));
    }

    @GetMapping(value = "/getZuApplyCount")
    public ResponseResult getZuApplyCount() {
        return ResponseResult.ok(applyService.getZuApplyCount());
    }

    @GetMapping(value = "/getZuAllApplyOut")
    public ResponseResult getZuAllApplyOut(Integer pageNum, Integer num) {
        return ResponseResult.ok(applyService.getAllApplyOut(pageNum, num));
    }

    @GetMapping(value = "/getZuApplyOutCount")
    public ResponseResult getZuApplyOutCount() {
        return ResponseResult.ok(applyService.getZuApplyOutCount());
    }

    @DeleteMapping(value = "/deleteApplyOut")
    public ResponseResult deleteApplyOut(Integer id) {
        return ResponseResult.ok(applyService.deleteApplyOut(id));
    }

}
