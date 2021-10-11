package cn.myt.demo2.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义全局异常处理
 *
 * @author mayating
 * @date 2021/10/11 10:20 上午
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义的业务异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResultResponse bizExceptionHanlder(HttpServletRequest req, BizException e) {
        logger.error("发生业务异常！原因是：{}", e.getErrorMsg());
        return ResultResponse.error(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultResponse exceptionHandler(HttpServletRequest req, NullPointerException e) {
        logger.error("发生空指针异常！原因是：{}", e);
        return ResultResponse.error(ExceptionEnum.BODY_NOT_MATCH);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultResponse exceptionHanlder(HttpServletRequest req, Exception e) {
        logger.error("未知异常！原因是: ", e);
        return ResultResponse.error(ExceptionEnum.INTERNAL_SERVER_ERROR);
    }

    // 2.添加异常处理方法

    /**
     * 处理类型转换异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NumberFormatException.class)
    @ResponseBody
    public ResultResponse exceptionHandler(HttpServletRequest req, NumberFormatException e) {
        logger.error("发生类型转换异常！原因是：", e);
        return ResultResponse.error(ExceptionEnum.PARAMS_NOT_CONVERT);
    }
}
