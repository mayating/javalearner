package cn.myt.demo2.exception;

/**
 * 异常处理枚举类
 *
 * @author mayating
 * @date 2021/10/11 10:04 上午
 */
public enum ExceptionEnum implements BaseErrorInfoInterface {
    //数据操作错误定义
    SUCCESS("2000", "成功！"),
    BODY_NOT_MATCH("4000", "请求的数据格式不符！"),
    SIGNATRUE_NOT_MATCH("4001", "请求的数字签名不匹配！"),
    NOT_FOUND("4004", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("5000", "服务器内部错误！"),
    SERVER_BUSY("5003", "服务器正忙，请稍后再试！"),

    //1.添加异常枚举类
    PARAMS_NOT_CONVERT("4002", "类型转换不对!");

    /**
     * 错误码
     */
    private final String resultCode;
    /**
     * 错误描述
     */
    private final String resultMsg;

    ExceptionEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public String getResultCode() {
        return this.resultCode;
    }

    @Override
    public String getResultMsg() {
        return this.resultMsg;
    }
}
