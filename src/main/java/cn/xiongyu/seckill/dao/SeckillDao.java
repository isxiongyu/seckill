package cn.xiongyu.seckill.dao;

import cn.xiongyu.seckill.bean.Goods;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: SeckillDao
 * Package: cn.xiongyu.seckill.dao
 * Description:
 * Date: 19-8-12 下午1:58
 * Author: xiongyu
 */
@Mapper
public interface SeckillDao {
    Goods selGoods(int seckillId);
}
