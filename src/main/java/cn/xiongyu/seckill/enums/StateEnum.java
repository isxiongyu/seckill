package cn.xiongyu.seckill.enums;

/**
 * ClassName: StateEnum
 * Package: cn.xiongyu.seckill.enums
 * Description:
 * Date: 19-8-12 下午7:12
 * Author: xiongyu
 */
public enum StateEnum {

    SUCCESS(1, "秒杀成功"),
    END(0, "秒杀结束"),
    REPEAT_KILL(-1, "重复秒杀"),
    INNER_ERROR(-2, "内部错误"),
    DATA_WRITE(-3, "数据篡改");

    private int state;

    private String stateInf;

    StateEnum(int state, String stateInf) {
        this.state = state;
        this.stateInf = stateInf;
    }

    public int getState() {
        return state;
    }

    public String getStateInf() {
        return stateInf;
    }
}
