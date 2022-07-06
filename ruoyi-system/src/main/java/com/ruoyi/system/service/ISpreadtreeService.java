package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Spreadtree;
import com.ruoyi.system.domain.SpreadtreePersonInfo;

/**
 * 传播链条Service接口
 *
 * @author Martin
 * @date 2022-07-04
 */
public interface ISpreadtreeService
{
    /**
     * 查询传播链条
     *
     * @param spreadtreeId 传播链条主键
     * @return 传播链条
     */
    public Spreadtree selectSpreadtreeBySpreadtreeId(Long spreadtreeId);

    /**
     * 查询传播链条列表
     *
     * @param spreadtree 传播链条
     * @return 传播链条集合
     */

    public List<Spreadtree> selectSpreadtreeList(Spreadtree spreadtree);

    public List<SpreadtreePersonInfo> selectSpreadtreePersonInfoList(Spreadtree spreadtree);
    /**
     * 新增传播链条
     *
     * @param spreadtree 传播链条
     * @return 结果
     */
    public int insertSpreadtree(Spreadtree spreadtree);

    /**
     * 修改传播链条
     *
     * @param spreadtree 传播链条
     * @return 结果
     */
    public int updateSpreadtree(Spreadtree spreadtree);

    /**
     * 批量删除传播链条
     *
     * @param spreadtreeIds 需要删除的传播链条主键集合
     * @return 结果
     */
    public int deleteSpreadtreeBySpreadtreeIds(Long[] spreadtreeIds);

    /**
     * 删除传播链条信息
     *
     * @param spreadtreeId 传播链条主键
     * @return 结果
     */
    public int deleteSpreadtreeBySpreadtreeId(Long spreadtreeId);
}
