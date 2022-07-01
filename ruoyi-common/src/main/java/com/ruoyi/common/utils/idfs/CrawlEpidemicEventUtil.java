package com.ruoyi.common.utils.idfs;

public class CrawlEpidemicEventUtil {
    public static boolean crawlEpidemicEventIntoDB(){
        return PythonUtil.executePythonFile("ruoyi-admin/src/main/resources/python/CrawlEpidemicEvents.py");
    }
}
