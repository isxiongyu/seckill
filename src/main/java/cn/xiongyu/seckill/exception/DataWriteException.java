package cn.xiongyu.seckill.exception;

/**
 * ClassName: DataWriteException
 * Package: cn.xiongyu.seckill.exception
 * Description:
 * Date: 19-8-12 下午7:47
 * Author: xiongyu
 */
public class DataWriteException extends RuntimeException {
    public DataWriteException() {
    }

    public DataWriteException(String message) {
        super(message);
    }
}
