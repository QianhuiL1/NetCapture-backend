package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AncestorsInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 行政区域Mapper接口
 *
 * @author ruoyi
 * @date 2022-06-28
 */

@Mapper
public interface AncestorsInfoMapper
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
     * 删除行政区域
     *
     * @param ancestorId 行政区域主键
     * @return 结果
     */
    public int deleteAncestorsInfoByAncestorId(String ancestorId);

    /**
     * 批量删除行政区域
     *
     * @param ancestorIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAncestorsInfoByAncestorIds(String[] ancestorIds);
}
