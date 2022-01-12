package com.house.pojo.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @Author xpdxz
 * @ClassName UserDto
 * @Description TODO
 * @Date 2022/1/12 9:56
 */

@Data
@ToString
public class UserDto {

    private Integer id;

    private Integer userInfoId;

    private String name;

    private String idCard;

    private String phone;

}
