package com.house.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author xpdxz
 */
@Data
@ToString
public class ApplyOut {
    private Integer id;

    private String houseId;

    private String address;

    private String status;

    private String name;

    private String phone;

    private String idCard;

    private Integer userListId;
}