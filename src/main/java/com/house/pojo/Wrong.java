package com.house.pojo;


import lombok.Data;
import lombok.ToString;

import java.sql.Date;

/**
 * @author xpdxz
 */
@Data
@ToString
public class Wrong {
    private Integer id;

    private String houseId;

    private String address;

    private Date date;

    private String name;

    private Integer userListId;

    private String status;

    private String detail;

}