package cn.xiongyu.seckill.dto;

import java.util.Date;

/**
 * ClassName: Exposer
 * Package: cn.xiongyu.seckill.dto
 * Description:
 * Date: 19-8-12 下午6:53
 * Author: xiongyu
 */
public class Exposer {
    private boolean exposed;
    private String md5;
    private Date now;
    private Date startTime;
    private Date endTime;

    public Exposer(boolean exposed, String md5, Date now, Date startTime, Date endTime) {
        this.exposed = exposed;
        this.md5 = md5;
        this.now = now;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Exposer(boolean exposed, String md5) {
        this.exposed = exposed;
        this.md5 = md5;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Exposer{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", now=" + now +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
