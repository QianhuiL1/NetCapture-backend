package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TodayEpidemicInfo;

/**
 * 当天疫情Service接口
 *
 * @author SoLam
 * @date 2022-06-29
 */
public interface ITodayEpidemicInfoService
{
    /**
     * 查询当天疫情
     *
     * @param todayepidemicid 当天疫情主键
     * @return 当天疫情
     */
    public TodayEpidemicInfo selectTodayEpidemicInfoByTodayepidemicid(Long todayepidemicid);

    /**
     * 查询当天疫情列表
     *
     * @param todayEpidemicInfo 当天疫情
     * @return 当天疫情集合
     */
    public List<TodayEpidemicInfo> selectTodayEpidemicInfoList(TodayEpidemicInfo todayEpidemicInfo);

    /**
     * 新增当天疫情
     *
     * @param todayEpidemicInfo 当天疫情
     * @return 结果
     */
    public int insertTodayEpidemicInfo(TodayEpidemicInfo todayEpidemicInfo);

    /**
     * 修改当天疫情
     *
     * @param todayEpidemicInfo 当天疫情
     * @return 结果
     */
    public int updateTodayEpidemicInfo(TodayEpidemicInfo todayEpidemicInfo);

    /**
     * 批量删除当天疫情
     *
     * @param todayepidemicids 需要删除的当天疫情主键集合
     * @return 结果
     */
    public int deleteTodayEpidemicInfoByTodayepidemicids(Long[] todayepidemicids);

    /**
     * 删除当天疫情信息
     *
     * @param todayepidemicid 当天疫情主键
     * @return 结果
     */
    public int deleteTodayEpidemicInfoByTodayepidemicid(Long todayepidemicid);

    //查询省份当天疫情信息列表
    public List<TodayEpidemicInfo> selectTodayProvinceEpidemicInfoList();

}
