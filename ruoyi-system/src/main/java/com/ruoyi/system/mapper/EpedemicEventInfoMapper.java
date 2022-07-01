package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.EpedemicEventInfo;

/**
 * 疫情新闻Mapper接口
 *
 * @author SoLam
 * @date 2022-06-30
 */
public interface EpedemicEventInfoMapper
{
    /**
     * 查询疫情新闻
     *
     * @param eventid 疫情新闻主键
     * @return 疫情新闻
     */
    public EpedemicEventInfo selectEpedemicEventInfoByEventid(Long eventid);

    /**
     * 查询疫情新闻列表
     *
     * @param epedemicEventInfo 疫情新闻
     * @return 疫情新闻集合
     */
    public List<EpedemicEventInfo> selectEpedemicEventInfoList();

    /**
     * 新增疫情新闻
     *
     * @param epedemicEventInfo 疫情新闻
     * @return 结果
     */
    public int insertEpedemicEventInfo(EpedemicEventInfo epedemicEventInfo);

    /**
     * 修改疫情新闻
     *
     * @param epedemicEventInfo 疫情新闻
     * @return 结果
     */
    public int updateEpedemicEventInfo(EpedemicEventInfo epedemicEventInfo);

    /**
     * 删除疫情新闻
     *
     * @param eventid 疫情新闻主键
     * @return 结果
     */
    public int deleteEpedemicEventInfoByEventid(Long eventid);

    /**
     * 批量删除疫情新闻
     *
     * @param eventids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEpedemicEventInfoByEventids(Long[] eventids);
}
