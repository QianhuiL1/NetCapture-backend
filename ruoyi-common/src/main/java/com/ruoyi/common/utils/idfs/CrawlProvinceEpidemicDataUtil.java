package com.ruoyi.common.utils.idfs;

public class CrawlProvinceEpidemicDataUtil {

    public static boolean crawlDataSavedIntoDB(){
        return PythonUtil.executePythonFile("ruoyi-admin/src/main/resources/python/CrawlProvinceEpidemicData.py");
    }
}
