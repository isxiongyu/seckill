package cn.xiongyu.seckill.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: WebMvcConfig
 * Package: cn.xiongyu.seckill.config
 * Description:
 * Date: 19-8-13 下午5:14
 * Author: xiongyu
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/seckill/list");
        registry.addViewController("/index.html").setViewName("edirect:/seckill/list");
    }
}
