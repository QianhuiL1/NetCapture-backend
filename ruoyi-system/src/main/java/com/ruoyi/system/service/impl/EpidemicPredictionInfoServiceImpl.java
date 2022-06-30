package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EpidemicPredictionInfoMapper;
import com.ruoyi.system.domain.EpidemicPredictionInfo;
import com.ruoyi.system.service.IEpidemicPredictionInfoService;

/**
 * 疫情预测Service业务层处理
 * 
 * @author SoLam
 * @date 2022-06-30
 */
@Service
public class EpidemicPredictionInfoServiceImpl implements IEpidemicPredictionInfoService 
{
    @Autowired
    private EpidemicPredictionInfoMapper epidemicPredictionInfoMapper;

    /**
     * 查询疫情预测
     * 
     * @param id 疫情预测主键
     * @return 疫情预测
     */
    @Override
    public EpidemicPredictionInfo selectEpidemicPredictionInfoById(Long id)
    {
        return epidemicPredictionInfoMapper.selectEpidemicPredictionInfoById(id);
    }

    /**
     * 查询疫情预测列表
     * 
     * @param epidemicPredictionInfo 疫情预测
     * @return 疫情预测
     */
    @Override
    public List<EpidemicPredictionInfo> selectEpidemicPredictionInfoList(EpidemicPredictionInfo epidemicPredictionInfo)
    {
        return epidemicPredictionInfoMapper.selectEpidemicPredictionInfoList(epidemicPredictionInfo);
    }

    /**
     * 新增疫情预测
     * 
     * @param epidemicPredictionInfo 疫情预测
     * @return 结果
     */
    @Override
    public int insertEpidemicPredictionInfo(EpidemicPredictionInfo epidemicPredictionInfo)
    {
        return epidemicPredictionInfoMapper.insertEpidemicPredictionInfo(epidemicPredictionInfo);
    }

    /**
     * 修改疫情预测
     * 
     * @param epidemicPredictionInfo 疫情预测
     * @return 结果
     */
    @Override
    public int updateEpidemicPredictionInfo(EpidemicPredictionInfo epidemicPredictionInfo)
    {
        return epidemicPredictionInfoMapper.updateEpidemicPredictionInfo(epidemicPredictionInfo);
    }

    /**
     * 批量删除疫情预测
     * 
     * @param ids 需要删除的疫情预测主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicPredictionInfoByIds(Long[] ids)
    {
        return epidemicPredictionInfoMapper.deleteEpidemicPredictionInfoByIds(ids);
    }

    /**
     * 删除疫情预测信息
     * 
     * @param id 疫情预测主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicPredictionInfoById(Long id)
    {
        return epidemicPredictionInfoMapper.deleteEpidemicPredictionInfoById(id);
    }
}
