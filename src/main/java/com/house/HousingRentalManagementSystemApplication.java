package com.house;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author xpdxz
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.house.dao")
@EnableConfigurationProperties
public class HousingRentalManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HousingRentalManagementSystemApplication.class, args);
    }

}
