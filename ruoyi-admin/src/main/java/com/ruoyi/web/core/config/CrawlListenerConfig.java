package com.ruoyi.web.core.config;

import com.ruoyi.common.utils.idfs.CrawlProvinceEpidemicDataUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
@EnableScheduling
public class CrawlListenerConfig {

    //每天凌晨两点更新数据
    @Scheduled(cron = "0 00 02 * * ?")
    private void configureTasks() {
        System.out.println("[CrawlListenerUtil " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "]" + "自动更新数据");
        CrawlProvinceEpidemicDataUtil.crawlDataSavedIntoDB();
    }
}
