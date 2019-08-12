package cn.xiongyu.seckill.dao;

import cn.xiongyu.seckill.entity.Seckill;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * ClassName: SeckillDao
 * Package: cn.xiongyu.seckill.dao
 * Description:
 * Date: 19-8-12 下午1:58
 * Author: xiongyu
 */
@Mapper
public interface SeckillDao {
    Seckill selSeckillById(int seckillId);
    List<Seckill> selAllSeckill();
    int ReduceNumber(int seckillId, Date killTime);
}
