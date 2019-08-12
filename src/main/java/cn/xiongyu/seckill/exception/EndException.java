package cn.xiongyu.seckill.exception;

/**
 * ClassName: EndException
 * Package: cn.xiongyu.seckill.exception
 * Description:
 * Date: 19-8-12 下午7:51
 * Author: xiongyu
 */
public class EndException extends RuntimeException {
    public EndException() {
    }

    public EndException(String message) {
        super(message);
    }
}
