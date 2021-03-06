package com.house.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author xpdxz
 */
@Data
@ToString
public class CheckOut {
    private Integer cid;

    private String houseId;

    private String address;

    private String status;

    private Integer userListId;
}