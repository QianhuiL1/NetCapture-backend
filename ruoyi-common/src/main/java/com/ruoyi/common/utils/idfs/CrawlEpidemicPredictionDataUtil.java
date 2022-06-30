package com.ruoyi.common.utils.idfs;

public class CrawlEpidemicPredictionDataUtil {
    public static boolean crawlDataSavedIntoDB(){
        return PythonUtil.executePythonFile("ruoyi-admin/src/main/resources/python/CrawlEpidemicPredictionData.py");
    }
}
