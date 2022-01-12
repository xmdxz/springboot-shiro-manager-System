package com.house.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private String password;

    private String type;

    private String salt;

}