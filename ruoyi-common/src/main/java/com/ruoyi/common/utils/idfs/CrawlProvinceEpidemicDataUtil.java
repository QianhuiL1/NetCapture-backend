package com.ruoyi.common.utils.idfs;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class CrawlProvinceEpidemicDataUtil {

    public static boolean crawlDataSavedIntoDB(){
        try{
            System.out.println("---------------更新数据----------------");
            File directory = new File("ruoyi-admin/src/main/resources/python/CrawlProvinceEpidemicData.py");
            //获取py文件路径
            String reportPath = directory.getCanonicalPath();
            //设置参数
            String[] args = new String[] { "python" , reportPath };
            // 执行py文件
            Process proc = Runtime.getRuntime().exec(args);
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String result = null;
            while ((result = in.readLine()) != null) {
                System.out.println(result);
            }
            in.close();
            proc.waitFor();
            System.out.println("---------------更新完毕----------------");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
