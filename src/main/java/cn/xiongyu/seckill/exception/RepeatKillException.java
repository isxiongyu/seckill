package cn.xiongyu.seckill.exception;

/**
 * ClassName: RepeatKillException
 * Package: cn.xiongyu.seckill.exception
 * Description:
 * Date: 19-8-12 下午7:54
 * Author: xiongyu
 */
public class RepeatKillException extends RuntimeException {
    public RepeatKillException() {
    }

    public RepeatKillException(String message) {
        super(message);
    }
}
