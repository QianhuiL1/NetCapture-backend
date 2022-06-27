package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SojournInfoMapper;
import com.ruoyi.system.domain.SojournInfo;
import com.ruoyi.system.service.ISojournInfoService;

/**
 * 旅居信息登记表Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-27
 */
@Service
public class SojournInfoServiceImpl implements ISojournInfoService
{
    @Autowired
    private SojournInfoMapper sojournInfoMapper;

    /**
     * 查询旅居信息登记表
     *
     * @param sourjornId 旅居信息登记表主键
     * @return 旅居信息登记表
     */
    @Override
    public SojournInfo selectSojournInfoBySourjornId(Long sourjornId)
    {
        return sojournInfoMapper.selectSojournInfoBySourjornId(sourjornId);
    }

    /**
     * 查询旅居信息登记表列表
     *
     * @param sojournInfo 旅居信息登记表
     * @return 旅居信息登记表
     */
    @Override
    public List<SojournInfo> selectSojournInfoList(SojournInfo sojournInfo)
    {
        return sojournInfoMapper.selectSojournInfoList(sojournInfo);
    }

    /**
     * 新增旅居信息登记表
     *
     * @param sojournInfo 旅居信息登记表
     * @return 结果
     */
    @Override
    public int insertSojournInfo(SojournInfo sojournInfo)
    {
        return sojournInfoMapper.insertSojournInfo(sojournInfo);
    }

    /**
     * 修改旅居信息登记表
     *
     * @param sojournInfo 旅居信息登记表
     * @return 结果
     */
    @Override
    public int updateSojournInfo(SojournInfo sojournInfo)
    {
        return sojournInfoMapper.updateSojournInfo(sojournInfo);
    }

    /**
     * 批量删除旅居信息登记表
     *
     * @param sourjornIds 需要删除的旅居信息登记表主键
     * @return 结果
     */
    @Override
    public int deleteSojournInfoBySourjornIds(Long[] sourjornIds)
    {
        return sojournInfoMapper.deleteSojournInfoBySourjornIds(sourjornIds);
    }

    /**
     * 删除旅居信息登记表信息
     *
     * @param sourjornId 旅居信息登记表主键
     * @return 结果
     */
    @Override
    public int deleteSojournInfoBySourjornId(Long sourjornId)
    {
        return sojournInfoMapper.deleteSojournInfoBySourjornId(sourjornId);
    }
}
