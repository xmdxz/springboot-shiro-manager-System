package com.house.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author xpdxz
 */
@Data
@ToString
public class HouseList {
    private Integer id;

    private String houseId;

    private String address;

    private Double area;

    private Double price;

    private String status;

}