package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AncestorsInfo;

/**
 * 行政区域Service接口
 *
 * @author ruoyi
 * @date 2022-06-28
 */
public interface IAncestorsInfoService
{
    /**
     * 查询行政区域
     *
     * @param ancestorId 行政区域主键
     * @return 行政区域
     */
    public AncestorsInfo selectAncestorsInfoByAncestorId(String ancestorId);

    /**
     * 查询行政区域列表
     *
     * @param ancestorsInfo 行政区域
     * @return 行政区域集合
     */
    public List<AncestorsInfo> selectAncestorsInfoList(AncestorsInfo ancestorsInfo);

    /**
     * 新增行政区域
     *
     * @param ancestorsInfo 行政区域
     * @return 结果
     */
    public int insertAncestorsInfo(AncestorsInfo ancestorsInfo);

    /**
     * 修改行政区域
     *
     * @param ancestorsInfo 行政区域
     * @return 结果
     */
    public int updateAncestorsInfo(AncestorsInfo ancestorsInfo);

    /**
     * 批量删除行政区域
     *
     * @param ancestorIds 需要删除的行政区域主键集合
     * @return 结果
     */
    public int deleteAncestorsInfoByAncestorIds(String[] ancestorIds);

    /**
     * 删除行政区域信息
     *
     * @param ancestorId 行政区域主键
     * @return 结果
     */
    public int deleteAncestorsInfoByAncestorId(String ancestorId);

    public int changeAncestorStatus(String ancestorIds);
}
