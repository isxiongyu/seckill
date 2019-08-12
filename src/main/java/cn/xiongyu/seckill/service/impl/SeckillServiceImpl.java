package cn.xiongyu.seckill.service.impl;

import cn.xiongyu.seckill.dao.SeckillDao;
import cn.xiongyu.seckill.dao.SuccessKilledDao;
import cn.xiongyu.seckill.dto.Exposer;
import cn.xiongyu.seckill.dto.SeckillExecution;
import cn.xiongyu.seckill.entity.Seckill;
import cn.xiongyu.seckill.entity.SuccessKilled;
import cn.xiongyu.seckill.enums.StateEnum;
import cn.xiongyu.seckill.exception.DataWriteException;
import cn.xiongyu.seckill.exception.EndException;
import cn.xiongyu.seckill.exception.RepeatKillException;
import cn.xiongyu.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * ClassName: SeckillServiceImpl
 * Package: cn.xiongyu.seckill.service.impl
 * Description:
 * Date: 19-8-12 下午7:25
 * Author: xiongyu
 */
@Service
public class SeckillServiceImpl implements SeckillService {

//    随便给定一个加密值
    private final String slat = "asjnfr93408fndmajs-eq0i";

    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Override
    public Seckill getOneSeckill(int seckillId) {
        return seckillDao.selSeckillById(seckillId);
    }

    @Override
    public List<Seckill> getAllSeckill() {
        return seckillDao.selAllSeckill();
    }

    @Override
    public Exposer getExportUrl(int seckillId) {
        Seckill seckill = seckillDao.selSeckillById(seckillId);
        Date now = new Date();
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        String md5 = getMd5(seckillId);
        if(startTime.getTime() > now.getTime() || endTime.getTime() < now.getTime()){
            return new Exposer(false, md5, now, startTime, endTime);
        }else {
            return new Exposer(true, md5, now, startTime, endTime);
        }
    }

    @Transactional
    @Override
    public SeckillExecution executionKill(int seckillId, String phone, String md5) throws DataWriteException, EndException, RepeatKillException {
        if (md5 == null || !md5.equals(getMd5(seckillId))) {
            throw new DataWriteException("数据被篡改");
        }
        Date now = new Date();
        int updateCount = seckillDao.ReduceNumber(seckillId, now);
        if (updateCount <= 0){
            throw new EndException("秒杀已经结束");
        }else {
            int insertCount = successKilledDao.insertSuccessRecord(seckillId, phone);
            if (insertCount <= 0){
                throw new RepeatKillException("重复秒杀");
            }else {
                SuccessKilled successKilled = successKilledDao.selSuccessKilled(seckillId, phone);
                return new SeckillExecution(seckillId, StateEnum.SUCCESS, successKilled);
            }
        }
    }


    //    获得MD5编码
    private String getMd5(int seckillId) {
        String str = seckillId + "/" + slat;
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
}
