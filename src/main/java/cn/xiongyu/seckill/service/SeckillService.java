package cn.xiongyu.seckill.service;

import cn.xiongyu.seckill.dto.Exposer;
import cn.xiongyu.seckill.dto.SeckillExecution;
import cn.xiongyu.seckill.entity.Seckill;
import cn.xiongyu.seckill.dao.SeckillDao;
import cn.xiongyu.seckill.dao.SuccessKilledDao;
import cn.xiongyu.seckill.exception.DataWriteException;
import cn.xiongyu.seckill.exception.EndException;
import cn.xiongyu.seckill.exception.RepeatKillException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: SeckillService
 * Package: cn.xiongyu.seckill.service
 * Description:
 * Date: 19-8-12 下午6:46
 * Author: xiongyu
 */
@Service
public interface SeckillService {

    Seckill getOneSeckill(int seckillId);

    List<Seckill> getAllSeckill();

    Exposer getExportUrl(int seckillId);

    SeckillExecution executionKill(int seckillId, String phone, String md5) throws DataWriteException, EndException, RepeatKillException;


}
