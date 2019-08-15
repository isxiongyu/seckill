package cn.xiongyu.seckill.dto;

import cn.xiongyu.seckill.entity.SuccessKilled;
import cn.xiongyu.seckill.enums.StateEnum;

/**
 * ClassName: SeckillExecution
 * Package: cn.xiongyu.seckill.dto
 * Description:
 * Date: 19-8-12 下午7:09
 * Author: xiongyu
 */
public class SeckillExecution {

    private boolean success;

    private int seckillId;

    private int state;

    private String stateInf;

    private SuccessKilled successKilled;

    public SeckillExecution(boolean success, int seckillId, int state, String stateInf) {
        this.success = success;
        this.seckillId = seckillId;
        this.state = state;
        this.stateInf = stateInf;
    }

    public SeckillExecution(boolean success, int seckillId, int state, String stateInf, SuccessKilled successKilled) {
        this.success = success;
        this.seckillId = seckillId;
        this.state = state;
        this.stateInf = stateInf;
        this.successKilled = successKilled;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(int seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInf() {
        return stateInf;
    }

    public void setStateInf(String stateInf) {
        this.stateInf = stateInf;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }

    @Override
    public String toString() {
        return "SeckillExecution{" +
                "success=" + success +
                ", seckillId=" + seckillId +
                ", state=" + state +
                ", stateInf=" + stateInf +
                ", successKilled=" + successKilled +
                '}';
    }
}
