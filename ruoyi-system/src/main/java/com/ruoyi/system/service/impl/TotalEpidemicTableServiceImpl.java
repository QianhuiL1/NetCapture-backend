package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TotalEpidemicTableMapper;
import com.ruoyi.system.domain.TotalEpidemicTable;
import com.ruoyi.system.service.ITotalEpidemicTableService;

/**
 * 整体疫情Service业务层处理
 * 
 * @author SoLam
 * @date 2022-06-29
 */
@Service
public class TotalEpidemicTableServiceImpl implements ITotalEpidemicTableService 
{
    @Autowired
    private TotalEpidemicTableMapper totalEpidemicTableMapper;

    /**
     * 查询整体疫情
     * 
     * @param totalepidemicid 整体疫情主键
     * @return 整体疫情
     */
    @Override
    public TotalEpidemicTable selectTotalEpidemicTableByTotalepidemicid(Long totalepidemicid)
    {
        return totalEpidemicTableMapper.selectTotalEpidemicTableByTotalepidemicid(totalepidemicid);
    }

    /**
     * 查询整体疫情列表
     * 
     * @param totalEpidemicTable 整体疫情
     * @return 整体疫情
     */
    @Override
    public List<TotalEpidemicTable> selectTotalEpidemicTableList(TotalEpidemicTable totalEpidemicTable)
    {
        return totalEpidemicTableMapper.selectTotalEpidemicTableList(totalEpidemicTable);
    }

    /**
     * 新增整体疫情
     * 
     * @param totalEpidemicTable 整体疫情
     * @return 结果
     */
    @Override
    public int insertTotalEpidemicTable(TotalEpidemicTable totalEpidemicTable)
    {
        return totalEpidemicTableMapper.insertTotalEpidemicTable(totalEpidemicTable);
    }

    /**
     * 修改整体疫情
     * 
     * @param totalEpidemicTable 整体疫情
     * @return 结果
     */
    @Override
    public int updateTotalEpidemicTable(TotalEpidemicTable totalEpidemicTable)
    {
        return totalEpidemicTableMapper.updateTotalEpidemicTable(totalEpidemicTable);
    }

    /**
     * 批量删除整体疫情
     * 
     * @param totalepidemicids 需要删除的整体疫情主键
     * @return 结果
     */
    @Override
    public int deleteTotalEpidemicTableByTotalepidemicids(Long[] totalepidemicids)
    {
        return totalEpidemicTableMapper.deleteTotalEpidemicTableByTotalepidemicids(totalepidemicids);
    }

    /**
     * 删除整体疫情信息
     * 
     * @param totalepidemicid 整体疫情主键
     * @return 结果
     */
    @Override
    public int deleteTotalEpidemicTableByTotalepidemicid(Long totalepidemicid)
    {
        return totalEpidemicTableMapper.deleteTotalEpidemicTableByTotalepidemicid(totalepidemicid);
    }
}
