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

    private int seckillId;

    private StateEnum stateEnum;

    private SuccessKilled successKilled;

    public SeckillExecution(int seckillId, StateEnum stateEnum, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.stateEnum = stateEnum;
        this.successKilled = successKilled;
    }

    public int getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(int seckillId) {
        this.seckillId = seckillId;
    }

    public StateEnum getStateEnum() {
        return stateEnum;
    }

    public void setStateEnum(StateEnum stateEnum) {
        this.stateEnum = stateEnum;
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
                "seckillId=" + seckillId +
                ", stateEnum=" + stateEnum +
                ", successKilled=" + successKilled +
                '}';
    }
}
