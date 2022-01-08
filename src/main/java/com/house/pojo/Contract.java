package com.house.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author xpdxz
 */
@Data
@ToString
public class Contract {
    private Integer id;

    private String chuZu;

    private String chuZuIdCard;

    private String zuKe;

    private String zuKeIdCard;

    private String fromDate;

    private String toDate;

    private Double price;

    private String address;

    private String houseId;

    private Integer payday;
}