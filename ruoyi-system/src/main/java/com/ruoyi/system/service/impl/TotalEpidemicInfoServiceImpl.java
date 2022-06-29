package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TotalEpidemicInfoMapper;
import com.ruoyi.system.domain.TotalEpidemicInfo;
import com.ruoyi.system.service.ITotalEpidemicInfoService;

/**
 * 整体疫情Service业务层处理
 * 
 * @author SoLam
 * @date 2022-06-29
 */
@Service
public class TotalEpidemicInfoServiceImpl implements ITotalEpidemicInfoService 
{
    @Autowired
    private TotalEpidemicInfoMapper totalEpidemicInfoMapper;

    /**
     * 查询整体疫情
     * 
     * @param totalepidemicid 整体疫情主键
     * @return 整体疫情
     */
    @Override
    public TotalEpidemicInfo selectTotalEpidemicInfoByTotalepidemicid(Long totalepidemicid)
    {
        return totalEpidemicInfoMapper.selectTotalEpidemicInfoByTotalepidemicid(totalepidemicid);
    }

    /**
     * 查询整体疫情列表
     * 
     * @param totalEpidemicInfo 整体疫情
     * @return 整体疫情
     */
    @Override
    public List<TotalEpidemicInfo> selectTotalEpidemicInfoList(TotalEpidemicInfo totalEpidemicInfo)
    {
        return totalEpidemicInfoMapper.selectTotalEpidemicInfoList(totalEpidemicInfo);
    }

    /**
     * 新增整体疫情
     * 
     * @param totalEpidemicInfo 整体疫情
     * @return 结果
     */
    @Override
    public int insertTotalEpidemicInfo(TotalEpidemicInfo totalEpidemicInfo)
    {
        return totalEpidemicInfoMapper.insertTotalEpidemicInfo(totalEpidemicInfo);
    }

    /**
     * 修改整体疫情
     * 
     * @param totalEpidemicInfo 整体疫情
     * @return 结果
     */
    @Override
    public int updateTotalEpidemicInfo(TotalEpidemicInfo totalEpidemicInfo)
    {
        return totalEpidemicInfoMapper.updateTotalEpidemicInfo(totalEpidemicInfo);
    }

    /**
     * 批量删除整体疫情
     * 
     * @param totalepidemicids 需要删除的整体疫情主键
     * @return 结果
     */
    @Override
    public int deleteTotalEpidemicInfoByTotalepidemicids(Long[] totalepidemicids)
    {
        return totalEpidemicInfoMapper.deleteTotalEpidemicInfoByTotalepidemicids(totalepidemicids);
    }

    /**
     * 删除整体疫情信息
     * 
     * @param totalepidemicid 整体疫情主键
     * @return 结果
     */
    @Override
    public int deleteTotalEpidemicInfoByTotalepidemicid(Long totalepidemicid)
    {
        return totalEpidemicInfoMapper.deleteTotalEpidemicInfoByTotalepidemicid(totalepidemicid);
    }
}
