package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TotalEpidemicTable;

/**
 * 整体疫情Service接口
 * 
 * @author SoLam
 * @date 2022-06-29
 */
public interface ITotalEpidemicTableService 
{
    /**
     * 查询整体疫情
     * 
     * @param totalepidemicid 整体疫情主键
     * @return 整体疫情
     */
    public TotalEpidemicTable selectTotalEpidemicTableByTotalepidemicid(Long totalepidemicid);

    /**
     * 查询整体疫情列表
     * 
     * @param totalEpidemicTable 整体疫情
     * @return 整体疫情集合
     */
    public List<TotalEpidemicTable> selectTotalEpidemicTableList(TotalEpidemicTable totalEpidemicTable);

    /**
     * 新增整体疫情
     * 
     * @param totalEpidemicTable 整体疫情
     * @return 结果
     */
    public int insertTotalEpidemicTable(TotalEpidemicTable totalEpidemicTable);

    /**
     * 修改整体疫情
     * 
     * @param totalEpidemicTable 整体疫情
     * @return 结果
     */
    public int updateTotalEpidemicTable(TotalEpidemicTable totalEpidemicTable);

    /**
     * 批量删除整体疫情
     * 
     * @param totalepidemicids 需要删除的整体疫情主键集合
     * @return 结果
     */
    public int deleteTotalEpidemicTableByTotalepidemicids(Long[] totalepidemicids);

    /**
     * 删除整体疫情信息
     * 
     * @param totalepidemicid 整体疫情主键
     * @return 结果
     */
    public int deleteTotalEpidemicTableByTotalepidemicid(Long totalepidemicid);
}
