package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RiskAreaInfoMapper;
import com.ruoyi.system.domain.RiskAreaInfo;
import com.ruoyi.system.service.IRiskAreaInfoService;

/**
 * 风险地区Service业务层处理
 * 
 * @author SoLam
 * @date 2022-07-06
 */
@Service
public class RiskAreaInfoServiceImpl implements IRiskAreaInfoService 
{
    @Autowired
    private RiskAreaInfoMapper riskAreaInfoMapper;

    /**
     * 查询风险地区
     * 
     * @param riskareaid 风险地区主键
     * @return 风险地区
     */
    @Override
    public RiskAreaInfo selectRiskAreaInfoByRiskareaid(Long riskareaid)
    {
        return riskAreaInfoMapper.selectRiskAreaInfoByRiskareaid(riskareaid);
    }

    /**
     * 查询风险地区列表
     * 
     * @param riskAreaInfo 风险地区
     * @return 风险地区
     */
    @Override
    public List<RiskAreaInfo> selectRiskAreaInfoList(RiskAreaInfo riskAreaInfo)
    {
        return riskAreaInfoMapper.selectRiskAreaInfoList(riskAreaInfo);
    }

    /**
     * 新增风险地区
     * 
     * @param riskAreaInfo 风险地区
     * @return 结果
     */
    @Override
    public int insertRiskAreaInfo(RiskAreaInfo riskAreaInfo)
    {
        return riskAreaInfoMapper.insertRiskAreaInfo(riskAreaInfo);
    }

    /**
     * 修改风险地区
     * 
     * @param riskAreaInfo 风险地区
     * @return 结果
     */
    @Override
    public int updateRiskAreaInfo(RiskAreaInfo riskAreaInfo)
    {
        return riskAreaInfoMapper.updateRiskAreaInfo(riskAreaInfo);
    }

    /**
     * 批量删除风险地区
     * 
     * @param riskareaids 需要删除的风险地区主键
     * @return 结果
     */
    @Override
    public int deleteRiskAreaInfoByRiskareaids(Long[] riskareaids)
    {
        return riskAreaInfoMapper.deleteRiskAreaInfoByRiskareaids(riskareaids);
    }

    /**
     * 删除风险地区信息
     * 
     * @param riskareaid 风险地区主键
     * @return 结果
     */
    @Override
    public int deleteRiskAreaInfoByRiskareaid(Long riskareaid)
    {
        return riskAreaInfoMapper.deleteRiskAreaInfoByRiskareaid(riskareaid);
    }
}
