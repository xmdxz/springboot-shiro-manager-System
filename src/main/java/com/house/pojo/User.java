package com.house.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author xpdxz
 */
@Data
@ToString
public class User {

    private Integer id;

    private String username;

    private String password;

    private String type;

    private String salt;

}