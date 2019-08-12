package cn.xiongyu.seckill.dao;

import cn.xiongyu.seckill.entity.SuccessKilled;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: SuccessKilledDao
 * Package: cn.xiongyu.seckill.dao
 * Description:
 * Date: 19-8-12 下午3:09
 * Author: xiongyu
 */
@Mapper
public interface SuccessKilledDao {
    int insertSuccessRecord(int seckillId, String phone);
    SuccessKilled selSuccessKilled(int seckillId, String phone);
}
