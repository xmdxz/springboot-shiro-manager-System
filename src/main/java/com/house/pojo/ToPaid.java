package com.house.pojo;


import lombok.Data;
import lombok.ToString;

import java.sql.Date;

/**
 * @author xpdxz
 */
@Data
@ToString
public class ToPaid {
    private Integer id;

    private String houseId;

    private String address;

    private Double price;

    private Date date;

    private String name;

    private Integer userListId;

    private String status;

}