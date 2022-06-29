package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TodayEpidemicInfoMapper;
import com.ruoyi.system.domain.TodayEpidemicInfo;
import com.ruoyi.system.service.ITodayEpidemicInfoService;

/**
 * 当天疫情Service业务层处理
 *
 * @author SoLam
 * @date 2022-06-29
 */
@Service
public class TodayEpidemicInfoServiceImpl implements ITodayEpidemicInfoService
{
    @Autowired
    private TodayEpidemicInfoMapper todayEpidemicInfoMapper;

    /**
     * 查询当天疫情
     *
     * @param todayepidemicid 当天疫情主键
     * @return 当天疫情
     */
    @Override
    public TodayEpidemicInfo selectTodayEpidemicInfoByTodayepidemicid(Long todayepidemicid)
    {
        return todayEpidemicInfoMapper.selectTodayEpidemicInfoByTodayepidemicid(todayepidemicid);
    }

    /**
     * 查询当天疫情列表
     *
     * @param todayEpidemicInfo 当天疫情
     * @return 当天疫情
     */
    @Override
    public List<TodayEpidemicInfo> selectTodayEpidemicInfoList(TodayEpidemicInfo todayEpidemicInfo)
    {
        return todayEpidemicInfoMapper.selectTodayEpidemicInfoList(todayEpidemicInfo);
    }

    /**
     * 新增当天疫情
     *
     * @param todayEpidemicInfo 当天疫情
     * @return 结果
     */
    @Override
    public int insertTodayEpidemicInfo(TodayEpidemicInfo todayEpidemicInfo)
    {
        return todayEpidemicInfoMapper.insertTodayEpidemicInfo(todayEpidemicInfo);
    }

    /**
     * 修改当天疫情
     *
     * @param todayEpidemicInfo 当天疫情
     * @return 结果
     */
    @Override
    public int updateTodayEpidemicInfo(TodayEpidemicInfo todayEpidemicInfo)
    {
        return todayEpidemicInfoMapper.updateTodayEpidemicInfo(todayEpidemicInfo);
    }

    /**
     * 批量删除当天疫情
     *
     * @param todayepidemicids 需要删除的当天疫情主键
     * @return 结果
     */
    @Override
    public int deleteTodayEpidemicInfoByTodayepidemicids(Long[] todayepidemicids)
    {
        return todayEpidemicInfoMapper.deleteTodayEpidemicInfoByTodayepidemicids(todayepidemicids);
    }

    /**
     * 删除当天疫情信息
     *
     * @param todayepidemicid 当天疫情主键
     * @return 结果
     */
    @Override
    public int deleteTodayEpidemicInfoByTodayepidemicid(Long todayepidemicid)
    {
        return todayEpidemicInfoMapper.deleteTodayEpidemicInfoByTodayepidemicid(todayepidemicid);
    }

    @Override
    public List<TodayEpidemicInfo> selectTodayProvinceEpidemicInfoList() {
        return todayEpidemicInfoMapper.selectTodayProvinceEpidemicInfoList();
    }
}
