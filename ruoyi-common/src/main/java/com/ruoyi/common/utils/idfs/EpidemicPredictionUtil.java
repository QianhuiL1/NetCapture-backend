package com.ruoyi.common.utils.idfs;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class EpidemicPredictionUtil {

    private String[] T;
    private String[] S;
    private String[] E;
    private String[] I;
    private String[] R;
    private String[] D;
    private String[] Q;
    private String[] Iq;
    private String[] sum_I;

    public String[] getT() {
        return T;
    }

    public void setT(String[] t) {
        T = t;
    }

    public String[] getS() {
        return S;
    }

    public void setS(String[] s) {
        S = s;
    }

    public String[] getE() {
        return E;
    }

    public void setE(String[] e) {
        E = e;
    }

    public String[] getI() {
        return I;
    }

    public void setI(String[] i) {
        I = i;
    }

    public String[] getR() {
        return R;
    }

    public void setR(String[] r) {
        R = r;
    }

    public String[] getD() {
        return D;
    }

    public void setD(String[] d) {
        D = d;
    }

    public String[] getQ() {
        return Q;
    }

    public void setQ(String[] q) {
        Q = q;
    }

    public String[] getIq() {
        return Iq;
    }

    public void setIq(String[] iq) {
        Iq = iq;
    }

    public String[] getSum_I() {
        return sum_I;
    }

    public void setSum_I(String[] sum_I) {
        this.sum_I = sum_I;
    }

    public void predicEpidemic(){
        try{
            File directory = new File("ruoyi-admin/src/main/resources/python/EpidemicPrediction.py");
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
                //T,S,E,I,R,D,Q,Iq,sum_I
                String[] result_split = result.split("] ");
                setT(result_split[0].substring(1).split(", "));
                setS(result_split[1].substring(1).split(", "));
                setE(result_split[2].substring(1).split(", "));
                setI(result_split[3].substring(1).split(", "));
                setR(result_split[4].substring(1).split(", "));
                setD(result_split[5].substring(1).split(", "));
                setQ(result_split[6].substring(1).split(", "));
                setIq(result_split[7].substring(1).split(", "));
                setSum_I(result_split[8].substring(1,result_split[8].length() - 1).split(", "));
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        EpidemicPredictionUtil predicter = new EpidemicPredictionUtil();
        predicter.predicEpidemic();
    }

}
