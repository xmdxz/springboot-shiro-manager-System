package com.house.controller;

import com.house.pojo.House;
import com.house.service.HouseService;
import com.house.util.RequestUtil;
import com.house.util.ResponseResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author xpdxz
 * @ClassName HouseController
 * @Description TODO
 * @Date 2022/1/11 12:03
 */

@RestController
@Log4j2
@RequestMapping(value = "/house")
public class HouseController {

    @Resource
    private HouseService houseService;

    @GetMapping(value = "/getHouses")
    public ResponseResult getHouses(Integer pageNum, Integer num) {
        return ResponseResult.ok(houseService.getHouses(pageNum, num));
    }

    @GetMapping(value = "/getHouseCount")
    public ResponseResult getHouseCount() {
        return ResponseResult.ok(houseService.getHouseCount());
    }

    @GetMapping(value = "/getHouse")
    public ResponseResult getHouse(Integer id) {
        if (RequestUtil.allParamsIsNull(id)) {
            return ResponseResult.error(501, "非法请求");
        }
        return ResponseResult.ok(houseService.getHouse(id));
    }

    @DeleteMapping(value = "/deleteHouse")
    public ResponseResult deleteHouse(Integer id) {
        return ResponseResult.ok(houseService.deleteHouse(id));
    }

    @PutMapping(value = "/addHouse")
    public ResponseResult addHouse(House house) {
        return ResponseResult.ok(houseService.addHouse(house));
    }

    @GetMapping(value = "/updateHouse")
    public ResponseResult updateHouse(House house) {
        return ResponseResult.ok(houseService.updateHouse(house));
    }

    @GetMapping(value = "/applyHouse")
    public ResponseResult applyHouse(House house) {
        return ResponseResult.ok(houseService.applyHouse(house));
    }
}
