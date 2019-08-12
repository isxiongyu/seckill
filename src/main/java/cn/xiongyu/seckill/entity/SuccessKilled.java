package cn.xiongyu.seckill.entity;

import java.util.Date;

/**
 * ClassName: SuccessKilled
 * Package: cn.xiongyu.seckill.entity
 * Description:
 * Date: 19-8-12 下午2:44
 * Author: xiongyu
 */
public class SuccessKilled {
    private Seckill seckill;
    private String phone;
    private int state;
    private Date createTime;

    public SuccessKilled() {
    }

    public SuccessKilled(Seckill seckill, String phone, int state, Date createTime) {
        this.seckill = seckill;
        this.phone = phone;
        this.state = state;
        this.createTime = createTime;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "seckill=" + seckill +
                ", phone='" + phone + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                '}';
    }
}
