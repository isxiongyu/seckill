package cn.xiongyu.seckill.controller;

import cn.xiongyu.seckill.entity.SuccessKilled;
import cn.xiongyu.seckill.dao.SuccessKilledDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName: SuccessKilledController
 * Package: cn.xiongyu.seckill.controller
 * Description:
 * Date: 19-8-12 下午3:21
 * Author: xiongyu
 */
@Controller
public class SuccessKilledController {
    @Autowired
    private SuccessKilledDao successKilledDao;
    @ResponseBody
    @GetMapping("/selSuccessKilled")
    public SuccessKilled selSuccessKilled(int seckillId, String phone){
        return successKilledDao.selSuccessKilled(seckillId, phone);
    }
}
