package com.heima.dingding.handler;

import com.heima.dingding.constant.MessageConstant;
import com.heima.dingding.exception.BaseException;
import com.heima.dingding.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 捕捉业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler
    public Result exception(BaseException e) {
        log.error("异常信息：{}", e.getMessage());
        return Result.error(e.getMessage());
    }

    /**
     * 处理重复添加两个用户
     */
    @ExceptionHandler
    public Result exception(SQLIntegrityConstraintViolationException e) {
        e.printStackTrace();
        String message = e.getMessage();
        if (message.contains("Duplicate entry")) {
            String[] s = message.split(" ");
            //提醒账号已存在
            return Result.error(s[2] + MessageConstant.ACCOUNT_ALREADY_EXISTS);
        }
        return Result.error(MessageConstant.UNKNOWN_ERROR);
    }


}
