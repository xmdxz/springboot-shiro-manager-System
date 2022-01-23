package com.house.exception;

import com.house.util.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * @Author xpdxz
 * @ClassName GlobalException
 * @Description TODO
 * @Date 2022/1/12 10:17
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = SQLException.class)
    public ResponseResult handleSql(SQLException sqlException) {
        return ResponseResult.error(500, "服务器异常，请联系管理员");
    }

}
