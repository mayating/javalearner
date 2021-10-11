package cn.myt.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mayating
 * @date 2021/10/11 9:41 上午
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exceptionHandler(Exception e) {
        System.out.println("全局异常捕获>>:" + e);
        return "全局异常捕获，错误原因>>" + e.getMessage();
    }
}
