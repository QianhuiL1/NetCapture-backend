package com.ruoyi.common.utils.idfs;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CrawlProvinceEpidemicDataUtil {

    public static void crawlDataSavedAsCSV(){
        try{
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
            if ((result = in.readLine()) != null) {
                System.out.println(result.substring(1,result.length() - 1));

            }

            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        crawlDataSavedAsCSV();
    }

}
