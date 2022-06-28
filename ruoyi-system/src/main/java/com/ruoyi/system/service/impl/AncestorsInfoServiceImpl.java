package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AncestorsInfoMapper;
import com.ruoyi.system.domain.AncestorsInfo;
import com.ruoyi.system.service.IAncestorsInfoService;

/**
 * 行政区域Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-28
 */
@Service
public class AncestorsInfoServiceImpl implements IAncestorsInfoService
{
    @Autowired
    private AncestorsInfoMapper ancestorsInfoMapper;

    /**
     * 查询行政区域
     *
     * @param ancestorId 行政区域主键
     * @return 行政区域
     */
    @Override
    public AncestorsInfo selectAncestorsInfoByAncestorId(String ancestorId)
    {
        return ancestorsInfoMapper.selectAncestorsInfoByAncestorId(ancestorId);
    }

    /**
     * 查询行政区域列表
     *
     * @param ancestorsInfo 行政区域
     * @return 行政区域
     */
    @Override
    public List<AncestorsInfo> selectAncestorsInfoList(AncestorsInfo ancestorsInfo)
    {
        return ancestorsInfoMapper.selectAncestorsInfoList(ancestorsInfo);
    }

    /**
     * 新增行政区域
     *
     * @param ancestorsInfo 行政区域
     * @return 结果
     */
    @Override
    public int insertAncestorsInfo(AncestorsInfo ancestorsInfo)
    {
        return ancestorsInfoMapper.insertAncestorsInfo(ancestorsInfo);
    }

    /**
     * 修改行政区域
     *
     * @param ancestorsInfo 行政区域
     * @return 结果
     */
    @Override
    public int updateAncestorsInfo(AncestorsInfo ancestorsInfo)
    {
        return ancestorsInfoMapper.updateAncestorsInfo(ancestorsInfo);
    }

    /**
     * 批量删除行政区域
     *
     * @param ancestorIds 需要删除的行政区域主键
     * @return 结果
     */
    @Override
    public int deleteAncestorsInfoByAncestorIds(String[] ancestorIds)
    {
        return ancestorsInfoMapper.deleteAncestorsInfoByAncestorIds(ancestorIds);
    }

    /**
     * 删除行政区域信息
     *
     * @param ancestorId 行政区域主键
     * @return 结果
     */
    @Override
    public int deleteAncestorsInfoByAncestorId(String ancestorId)
    {
        return ancestorsInfoMapper.deleteAncestorsInfoByAncestorId(ancestorId);
    }
}
