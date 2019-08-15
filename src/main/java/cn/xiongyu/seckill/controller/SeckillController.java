package cn.xiongyu.seckill.controller;

import cn.xiongyu.seckill.dto.Exposer;
import cn.xiongyu.seckill.dto.SeckillExecution;
import cn.xiongyu.seckill.entity.Seckill;
import cn.xiongyu.seckill.enums.StateEnum;
import cn.xiongyu.seckill.exception.DataWriteException;
import cn.xiongyu.seckill.exception.EndException;
import cn.xiongyu.seckill.exception.RepeatKillException;
import cn.xiongyu.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * ClassName: SeckillController
 * Package: cn.xiongyu.seckill.controller
 * Description:
 * Date: 19-8-12 下午1:58
 * Author: xiongyu
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    private SeckillService seckillService;

    @GetMapping("/list")
    private String list(Model model) {
        List<Seckill> list = seckillService.getAllSeckill();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/{seckillId}/detail")
    private String detail(@PathVariable Integer seckillId, Model model) {
        if (seckillId == null) {
            return "redirect:/seckill/list";
        }
        Seckill seckill = seckillService.getOneSeckill(seckillId);
        if (seckill == null) {
            return "redirect:/seckill/list";
        }
        model.addAttribute("seckill", seckill);
        return "detail";
    }

    @GetMapping("/{seckillId}/expose")
    @ResponseBody
    private Exposer expose(@PathVariable Integer seckillId, Model model) {
        Exposer exposer = seckillService.getExposer(seckillId);
        return exposer;
    }

    @PostMapping("/{seckillId}/{md5}/execution")
    @ResponseBody
    private SeckillExecution execution(
            @PathVariable Integer seckillId, @PathVariable String md5,
            @CookieValue(value = "killPhone", required = false) String phone) {
        try {
            SeckillExecution seckillExecution = seckillService.executionKill(seckillId, phone, md5);
            return seckillExecution;
        } catch (DataWriteException e) {
            SeckillExecution seckillExecution = new SeckillExecution(
                    false, seckillId, StateEnum.DATA_WRITE.getState(), StateEnum.DATA_WRITE.getStateInf());
            return seckillExecution;
        } catch (EndException e) {
            SeckillExecution seckillExecution = new SeckillExecution(
                    false, seckillId, StateEnum.END.getState(), StateEnum.END.getStateInf());
            return seckillExecution;
        } catch (RepeatKillException e) {
            SeckillExecution seckillExecution = new SeckillExecution(
                    false, seckillId, StateEnum.REPEAT_KILL.getState(), StateEnum.REPEAT_KILL.getStateInf());
            return seckillExecution;
        }
    }
    @GetMapping("/time/now")
    @ResponseBody
    private long now() {
        Date now = new Date();
        return now.getTime();
    }
}
