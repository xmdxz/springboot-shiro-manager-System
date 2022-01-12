package com.house.pojo.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @Author xpdxz
 * @ClassName RentInfo
 * @Description TODO
 * @Date 2022/1/11 16:04
 */
@Data
@ToString
public class RentInfo {
    private Integer id;
    private String houseId;
    private String price;
    private String address;
    private String name;
    private String idCard;
    private String phone;
    private Integer contractId;
    private String status;
    private Integer userInfoId;

}
