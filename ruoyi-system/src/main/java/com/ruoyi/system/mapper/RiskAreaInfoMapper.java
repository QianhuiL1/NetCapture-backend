package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.RiskAreaInfo;

/**
 * 风险地区Mapper接口
 * 
 * @author SoLam
 * @date 2022-07-06
 */
public interface RiskAreaInfoMapper 
{
    /**
     * 查询风险地区
     * 
     * @param riskareaid 风险地区主键
     * @return 风险地区
     */
    public RiskAreaInfo selectRiskAreaInfoByRiskareaid(Long riskareaid);

    /**
     * 查询风险地区列表
     * 
     * @param riskAreaInfo 风险地区
     * @return 风险地区集合
     */
    public List<RiskAreaInfo> selectRiskAreaInfoList(RiskAreaInfo riskAreaInfo);

    /**
     * 新增风险地区
     * 
     * @param riskAreaInfo 风险地区
     * @return 结果
     */
    public int insertRiskAreaInfo(RiskAreaInfo riskAreaInfo);

    /**
     * 修改风险地区
     * 
     * @param riskAreaInfo 风险地区
     * @return 结果
     */
    public int updateRiskAreaInfo(RiskAreaInfo riskAreaInfo);

    /**
     * 删除风险地区
     * 
     * @param riskareaid 风险地区主键
     * @return 结果
     */
    public int deleteRiskAreaInfoByRiskareaid(Long riskareaid);

    /**
     * 批量删除风险地区
     * 
     * @param riskareaids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRiskAreaInfoByRiskareaids(Long[] riskareaids);
}