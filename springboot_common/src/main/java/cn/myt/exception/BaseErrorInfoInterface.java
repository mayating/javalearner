package cn.myt.exception;

/**
 * 服务接口类
 *
 * @author mayating
 * @date 2021/10/11 9:59 上午
 */
public interface BaseErrorInfoInterface {

    /**
     * 错误码
     *
     * @return
     */
    String getResultCode();

    /**
     * 错误描述
     *
     * @return
     */
    String getResultMsg();
}
