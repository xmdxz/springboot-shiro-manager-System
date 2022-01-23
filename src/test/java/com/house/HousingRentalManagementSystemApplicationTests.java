package com.house;

import com.house.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class HousingRentalManagementSystemApplicationTests {

    @Test
    void jwtTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 0);
        map.put("username", "xpdxz");
        String token = JwtUtil.getJwtToken(map);
        System.out.println(token);
        Object id = JwtUtil.getBodyMessage("id", token);
        System.out.println(Integer.parseInt(id.toString()));
        System.out.println(token);
        System.out.println(JwtUtil.signToken(token));

    }

}
