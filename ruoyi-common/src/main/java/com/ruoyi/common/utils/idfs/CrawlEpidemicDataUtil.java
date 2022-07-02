package com.ruoyi.common.utils.idfs;

public class CrawlEpidemicDataUtil {

    public static boolean crawlDataSavedIntoDB(){
        return PythonUtil.executePythonFile("ruoyi-admin/src/main/resources/python/CrawlEpidemicData.py");
    }
}
