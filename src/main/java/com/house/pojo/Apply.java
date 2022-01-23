package com.house.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author xpdxz
 */
@Data
@ToString
public class Apply {
    private Integer id;

    private String houseId;

    private String address;

    private Double area;

    private Double price;

    private String status;

    private String name;

    private String phone;

    private String idCard;

    private Integer userListId;

}