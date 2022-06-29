package com.ruoyi.common.utils.idfs;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.time.LocalDateTime;

@Configuration
@EnableScheduling
public class CrawlListenerUtil {


    //3.添加定时任务
    @Scheduled(cron = "0 0 02 * * ?")
    //每天凌晨两点更新数据
    private void configureTasks() {
        System.out.println("执行静态定时任务时间: " + LocalDateTime.now());
    }

}
