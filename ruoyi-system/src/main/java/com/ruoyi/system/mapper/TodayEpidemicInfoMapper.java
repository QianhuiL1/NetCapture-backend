package com.ruoyi.system.mapper;

import java.util.Date;
import java.util.List;
import com.ruoyi.system.domain.TodayEpidemicInfo;

/**
 * 当天疫情Mapper接口
 *
 * @author SoLam
 * @date 2022-06-29
 */
public interface TodayEpidemicInfoMapper
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
     * 删除当天疫情
     *
     * @param todayepidemicid 当天疫情主键
     * @return 结果
     */
    public int deleteTodayEpidemicInfoByTodayepidemicid(Long todayepidemicid);

    /**
     * 批量删除当天疫情
     *
     * @param todayepidemicids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTodayEpidemicInfoByTodayepidemicids(Long[] todayepidemicids);

    //获取当天省份疫情信息
    public List<TodayEpidemicInfo> selectTodayProvinceEpidemicInfoList(String todayepidemicDate);

    //获取当天全国疫情信息
    public TodayEpidemicInfo selectTodayCountryEpidemicInfo(String todayepidemicDate);
}
