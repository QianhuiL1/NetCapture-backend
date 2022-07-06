package com.ruoyi.common.utils.idfs;

public class CrawlRiskAreaUtil {
    public static boolean crawlRiskAreaIntoDB(){
        return PythonUtil.executePythonFile("ruoyi-admin/src/main/resources/python/CrawlRiskArea.py");
    }
}
