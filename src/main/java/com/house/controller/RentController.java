package com.house.controller;

import com.house.pojo.Contract;
import com.house.pojo.dto.RentInfo;
import com.house.service.RentService;
import com.house.util.ResponseResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author xpdxz
 * @ClassName RentController
 * @Description TODO
 * @Date 2022/1/11 17:10
 */

@RestController
@RequestMapping(value = "/rent")
public class RentController {

    @Resource
    private RentService rentService;

    @DeleteMapping(value = "/deleteContract")
    public ResponseResult deleteContract(Integer contractId) {
        return ResponseResult.ok(rentService.deleteContract(contractId));
    }

    @GetMapping(value = "/getRents")
    public ResponseResult getRents(Integer pageNum, Integer num) {
        return ResponseResult.ok(rentService.getAllRentInfo(pageNum, num));
    }

    @GetMapping(value = "/getRentCount")
    public ResponseResult getRentCount() {
        return ResponseResult.ok(rentService.getRentCount());
    }

    @GetMapping(value = "/getZuRents")
    public ResponseResult getZuRents(Integer pageNum, Integer num) {
        return ResponseResult.ok(rentService.getZuRents(pageNum, num));
    }

    @GetMapping(value = "/getZuRentCount")
    public ResponseResult getZuRentCount() {
        return ResponseResult.ok(rentService.getZuRentCount());
    }

    @GetMapping(value = "/getContract")
    public ResponseResult getContract(Integer id) {
        return ResponseResult.ok(rentService.getContractById(id));
    }

    @GetMapping(value = "/updateContract")
    public ResponseResult updateContract(Contract contract) {
        return ResponseResult.ok(rentService.updateContract(contract));
    }

    @GetMapping(value = "/getCheckoutRents")
    public ResponseResult getCheckoutRents(Integer pageNum, Integer num) {
        return ResponseResult.ok(rentService.getAllCheckout(pageNum, num));
    }

    @GetMapping(value = "/getCheckoutRentCount")
    public ResponseResult getCheckoutRentCount() {
        return ResponseResult.ok(rentService.getCheckoutCount());
    }

    @DeleteMapping(value = "/deleteCheckout")
    public ResponseResult deleteCheckout(Integer id) {
        return ResponseResult.ok(rentService.deleteCheckout(id));
    }

    @GetMapping(value = "/applyOut")
    public ResponseResult applyOut(RentInfo rentInfo) {
        return ResponseResult.ok(rentService.applyOut(rentInfo));
    }

    @GetMapping(value = "/getZuCheckoutRents")
    public ResponseResult getZuCheckoutRents(Integer pageNum, Integer num) {
        return ResponseResult.ok(rentService.getZuAllCheckout(pageNum, num));
    }

    @GetMapping(value = "/getZuCheckoutRentCount")
    public ResponseResult getZuCheckoutRentCount() {
        return ResponseResult.ok(rentService.getZuCheckoutCount());
    }

    @GetMapping(value = "/getZuById")
    public ResponseResult getZuById(Integer id) {
        return ResponseResult.ok(rentService.getRentInfoById(id));
    }
}
