package cn.xiongyu.seckill;

import cn.xiongyu.seckill.dto.Exposer;
import cn.xiongyu.seckill.dto.SeckillExecution;
import cn.xiongyu.seckill.entity.Seckill;
import cn.xiongyu.seckill.service.SeckillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeckillApplicationTests {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SeckillService seckillService;
    @Test
    public void contextLoads() {
    }
    @Test
    public void test01() {
        int seckillId = 2;
        Seckill seckill = seckillService.getOneSeckill(seckillId);
        logger.info("seckill={}", seckill);
    }
    @Test
    public void test02() {
        int seckillId = 2;
        List<Seckill> seckill = seckillService.getAllSeckill();
        logger.info("seckill={}", seckill);
    }
    @Test
    public void test03() {
        int seckillId = 3;
        Exposer exposer = seckillService.getExportUrl(seckillId);
        logger.info("exposer={}", exposer);
    }
    @Test
    public void test04() {
        int seckillId = 3;
        String phone = "15555555555";
        String md5 = "6e4946b52c58f8a2c69780fb895e1300";
        SeckillExecution executionKill = seckillService.executionKill(seckillId, phone, md5);
        logger.info("executionKill={}", executionKill);
    }
}
