package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TodayEpidemicTableMapper;
import com.ruoyi.system.domain.TodayEpidemicTable;
import com.ruoyi.system.service.ITodayEpidemicTableService;

/**
 * 当天疫情Service业务层处理
 * 
 * @author SoLam
 * @date 2022-06-29
 */
@Service
public class TodayEpidemicTableServiceImpl implements ITodayEpidemicTableService 
{
    @Autowired
    private TodayEpidemicTableMapper todayEpidemicTableMapper;

    /**
     * 查询当天疫情
     * 
     * @param todayepidemicid 当天疫情主键
     * @return 当天疫情
     */
    @Override
    public TodayEpidemicTable selectTodayEpidemicTableByTodayepidemicid(Long todayepidemicid)
    {
        return todayEpidemicTableMapper.selectTodayEpidemicTableByTodayepidemicid(todayepidemicid);
    }

    /**
     * 查询当天疫情列表
     * 
     * @param todayEpidemicTable 当天疫情
     * @return 当天疫情
     */
    @Override
    public List<TodayEpidemicTable> selectTodayEpidemicTableList(TodayEpidemicTable todayEpidemicTable)
    {
        return todayEpidemicTableMapper.selectTodayEpidemicTableList(todayEpidemicTable);
    }

    /**
     * 新增当天疫情
     * 
     * @param todayEpidemicTable 当天疫情
     * @return 结果
     */
    @Override
    public int insertTodayEpidemicTable(TodayEpidemicTable todayEpidemicTable)
    {
        return todayEpidemicTableMapper.insertTodayEpidemicTable(todayEpidemicTable);
    }

    /**
     * 修改当天疫情
     * 
     * @param todayEpidemicTable 当天疫情
     * @return 结果
     */
    @Override
    public int updateTodayEpidemicTable(TodayEpidemicTable todayEpidemicTable)
    {
        return todayEpidemicTableMapper.updateTodayEpidemicTable(todayEpidemicTable);
    }

    /**
     * 批量删除当天疫情
     * 
     * @param todayepidemicids 需要删除的当天疫情主键
     * @return 结果
     */
    @Override
    public int deleteTodayEpidemicTableByTodayepidemicids(Long[] todayepidemicids)
    {
        return todayEpidemicTableMapper.deleteTodayEpidemicTableByTodayepidemicids(todayepidemicids);
    }

    /**
     * 删除当天疫情信息
     * 
     * @param todayepidemicid 当天疫情主键
     * @return 结果
     */
    @Override
    public int deleteTodayEpidemicTableByTodayepidemicid(Long todayepidemicid)
    {
        return todayEpidemicTableMapper.deleteTodayEpidemicTableByTodayepidemicid(todayepidemicid);
    }
}
