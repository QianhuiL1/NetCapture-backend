package com.ruoyi.web.core.config;

import com.ruoyi.common.utils.idfs.CrawlEpidemicEventUtil;
import com.ruoyi.common.utils.idfs.CrawlEpidemicPredictionDataUtil;
import com.ruoyi.common.utils.idfs.CrawlEpidemicDataUtil;
import com.ruoyi.common.utils.idfs.CrawlRiskAreaUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
@EnableScheduling
public class CrawlListenerConfig {

    //每天凌晨两点更新数据
    @Scheduled(cron = "00 00 02 * * ?")
    private void configureTasks() {
        System.out.println("[CrawlListenerUtil " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "]" + "自动更新数据");
        System.out.println("----------自动更新全国疫情数据----------");
        CrawlEpidemicDataUtil.crawlDataSavedIntoDB();
        System.out.println("----------全国疫情数据更新完毕----------");
        System.out.println("----------自动更新预测疫情数据----------");
        CrawlEpidemicPredictionDataUtil.crawlDataSavedIntoDB();
        System.out.println("----------预测疫情数据更新完毕----------");
        System.out.println("------------自动更新疫情新闻-----------");
        CrawlEpidemicEventUtil.crawlEpidemicEventIntoDB();
        System.out.println("------------疫情新闻更新完毕-----------");
        System.out.println("------------自动更新风险地区-----------");
        CrawlRiskAreaUtil.crawlRiskAreaIntoDB();
        System.out.println("------------风险地区更新完毕-----------");
        System.out.println("[CrawlListenerUtil " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "]" + "数据更新完毕");
    }
}
