package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EpedemicEventInfoMapper;
import com.ruoyi.system.domain.EpedemicEventInfo;
import com.ruoyi.system.service.IEpedemicEventInfoService;

/**
 * 疫情新闻Service业务层处理
 *
 * @author SoLam
 * @date 2022-06-30
 */
@Service
public class EpedemicEventInfoServiceImpl implements IEpedemicEventInfoService
{
    @Autowired
    private EpedemicEventInfoMapper epedemicEventInfoMapper;

    /**
     * 查询疫情新闻
     *
     * @param eventid 疫情新闻主键
     * @return 疫情新闻
     */
    @Override
    public EpedemicEventInfo selectEpedemicEventInfoByEventid(Long eventid)
    {
        return epedemicEventInfoMapper.selectEpedemicEventInfoByEventid(eventid);
    }

    /**
     * 查询疫情新闻列表
     *
     * @param epedemicEventInfo 疫情新闻
     * @return 疫情新闻
     */
    @Override
    public List<EpedemicEventInfo> selectEpedemicEventInfoList()
    {
        return epedemicEventInfoMapper.selectEpedemicEventInfoList();
    }

    /**
     * 新增疫情新闻
     *
     * @param epedemicEventInfo 疫情新闻
     * @return 结果
     */
    @Override
    public int insertEpedemicEventInfo(EpedemicEventInfo epedemicEventInfo)
    {
        return epedemicEventInfoMapper.insertEpedemicEventInfo(epedemicEventInfo);
    }

    /**
     * 修改疫情新闻
     *
     * @param epedemicEventInfo 疫情新闻
     * @return 结果
     */
    @Override
    public int updateEpedemicEventInfo(EpedemicEventInfo epedemicEventInfo)
    {
        return epedemicEventInfoMapper.updateEpedemicEventInfo(epedemicEventInfo);
    }

    /**
     * 批量删除疫情新闻
     *
     * @param eventids 需要删除的疫情新闻主键
     * @return 结果
     */
    @Override
    public int deleteEpedemicEventInfoByEventids(Long[] eventids)
    {
        return epedemicEventInfoMapper.deleteEpedemicEventInfoByEventids(eventids);
    }

    /**
     * 删除疫情新闻信息
     *
     * @param eventid 疫情新闻主键
     * @return 结果
     */
    @Override
    public int deleteEpedemicEventInfoByEventid(Long eventid)
    {
        return epedemicEventInfoMapper.deleteEpedemicEventInfoByEventid(eventid);
    }
}
