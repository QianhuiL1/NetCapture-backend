package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.TodayEpidemicInfo;
import com.ruoyi.system.domain.TotalEpidemicInfo;

/**
 * 整体疫情Mapper接口
 *
 * @author SoLam
 * @date 2022-06-29
 */
public interface TotalEpidemicInfoMapper
{
    /**
     * 查询整体疫情
     *
     * @param totalepidemicid 整体疫情主键
     * @return 整体疫情
     */
    public TotalEpidemicInfo selectTotalEpidemicInfoByTotalepidemicid(Long totalepidemicid);

    /**
     * 查询整体疫情列表
     *
     * @param totalEpidemicInfo 整体疫情
     * @return 整体疫情集合
     */
    public List<TotalEpidemicInfo> selectTotalEpidemicInfoList(TotalEpidemicInfo totalEpidemicInfo);

    /**
     * 新增整体疫情
     *
     * @param totalEpidemicInfo 整体疫情
     * @return 结果
     */
    public int insertTotalEpidemicInfo(TotalEpidemicInfo totalEpidemicInfo);

    /**
     * 修改整体疫情
     *
     * @param totalEpidemicInfo 整体疫情
     * @return 结果
     */
    public int updateTotalEpidemicInfo(TotalEpidemicInfo totalEpidemicInfo);

    /**
     * 删除整体疫情
     *
     * @param totalepidemicid 整体疫情主键
     * @return 结果
     */
    public int deleteTotalEpidemicInfoByTotalepidemicid(Long totalepidemicid);

    /**
     * 批量删除整体疫情
     *
     * @param totalepidemicids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTotalEpidemicInfoByTotalepidemicids(Long[] totalepidemicids);

    public List<TotalEpidemicInfo> selectTotalProvinceEpidemicInfoList(String totalepidemicDate);
}
