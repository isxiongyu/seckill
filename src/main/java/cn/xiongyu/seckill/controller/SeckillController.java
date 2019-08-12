package cn.xiongyu.seckill.controller;

import cn.xiongyu.seckill.bean.Goods;
import cn.xiongyu.seckill.dao.SeckillDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: SeckillController
 * Package: cn.xiongyu.seckill.controller
 * Description:
 * Date: 19-8-12 下午1:58
 * Author: xiongyu
 */
@RestController
public class SeckillController {
    @Autowired
    private SeckillDao seckillDao;
    @GetMapping("/selGoods")
    private Goods selGoods(int seckillId){
        return seckillDao.selGoods(seckillId);
    }
}
