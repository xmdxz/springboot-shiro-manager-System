package com.house.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author xpdxz
 */
@ToString
@Data
public class ZuList {
    private Integer zid;

    private String houseId;

    private Double price;

    private String address;

    private Integer userListId;

    private Integer contractId;
}