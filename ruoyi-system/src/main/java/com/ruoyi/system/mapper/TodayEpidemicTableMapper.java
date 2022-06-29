package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TodayEpidemicTable;

/**
 * 当天疫情Mapper接口
 * 
 * @author SoLam
 * @date 2022-06-29
 */
public interface TodayEpidemicTableMapper 
{
    /**
     * 查询当天疫情
     * 
     * @param todayepidemicid 当天疫情主键
     * @return 当天疫情
     */
    public TodayEpidemicTable selectTodayEpidemicTableByTodayepidemicid(Long todayepidemicid);

    /**
     * 查询当天疫情列表
     * 
     * @param todayEpidemicTable 当天疫情
     * @return 当天疫情集合
     */
    public List<TodayEpidemicTable> selectTodayEpidemicTableList(TodayEpidemicTable todayEpidemicTable);

    /**
     * 新增当天疫情
     * 
     * @param todayEpidemicTable 当天疫情
     * @return 结果
     */
    public int insertTodayEpidemicTable(TodayEpidemicTable todayEpidemicTable);

    /**
     * 修改当天疫情
     * 
     * @param todayEpidemicTable 当天疫情
     * @return 结果
     */
    public int updateTodayEpidemicTable(TodayEpidemicTable todayEpidemicTable);

    /**
     * 删除当天疫情
     * 
     * @param todayepidemicid 当天疫情主键
     * @return 结果
     */
    public int deleteTodayEpidemicTableByTodayepidemicid(Long todayepidemicid);

    /**
     * 批量删除当天疫情
     * 
     * @param todayepidemicids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTodayEpidemicTableByTodayepidemicids(Long[] todayepidemicids);
}
