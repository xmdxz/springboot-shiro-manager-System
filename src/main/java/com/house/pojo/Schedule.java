package com.house.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author xpdxz
 */
@ToString
@Data
public class Schedule {
    private Integer id;

    private String date;

    private String content;
}