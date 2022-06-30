package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.EpidemicPredictionInfo;

/**
 * 疫情预测Service接口
 * 
 * @author SoLam
 * @date 2022-06-30
 */
public interface IEpidemicPredictionInfoService 
{
    /**
     * 查询疫情预测
     * 
     * @param id 疫情预测主键
     * @return 疫情预测
     */
    public EpidemicPredictionInfo selectEpidemicPredictionInfoById(Long id);

    /**
     * 查询疫情预测列表
     * 
     * @param epidemicPredictionInfo 疫情预测
     * @return 疫情预测集合
     */
    public List<EpidemicPredictionInfo> selectEpidemicPredictionInfoList(EpidemicPredictionInfo epidemicPredictionInfo);

    /**
     * 新增疫情预测
     * 
     * @param epidemicPredictionInfo 疫情预测
     * @return 结果
     */
    public int insertEpidemicPredictionInfo(EpidemicPredictionInfo epidemicPredictionInfo);

    /**
     * 修改疫情预测
     * 
     * @param epidemicPredictionInfo 疫情预测
     * @return 结果
     */
    public int updateEpidemicPredictionInfo(EpidemicPredictionInfo epidemicPredictionInfo);

    /**
     * 批量删除疫情预测
     * 
     * @param ids 需要删除的疫情预测主键集合
     * @return 结果
     */
    public int deleteEpidemicPredictionInfoByIds(Long[] ids);

    /**
     * 删除疫情预测信息
     * 
     * @param id 疫情预测主键
     * @return 结果
     */
    public int deleteEpidemicPredictionInfoById(Long id);
}
