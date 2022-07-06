package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.system.domain.PersonInfo;
import com.ruoyi.system.domain.SpreadtreePersonInfo;
import com.ruoyi.system.mapper.PersonInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SpreadtreeMapper;
import com.ruoyi.system.domain.Spreadtree;
import com.ruoyi.system.service.ISpreadtreeService;

/**
 * 传播链条Service业务层处理
 *
 * @author Martin
 * @date 2022-07-04
 */
@Service
public class SpreadtreeServiceImpl implements ISpreadtreeService
{
    @Autowired
    private SpreadtreeMapper spreadtreeMapper;

    @Autowired
    private PersonInfoMapper personInfoMapper;
    /**
     * 查询传播链条
     *
     * @param spreadtreeId 传播链条主键
     * @return 传播链条
     */
    @Override
    public Spreadtree selectSpreadtreeBySpreadtreeId(Long spreadtreeId)
    {
        return spreadtreeMapper.selectSpreadtreeBySpreadtreeId(spreadtreeId);
    }

    /**
     * 查询传播链条列表
     *
     * @param spreadtree 传播链条
     * @return 传播链条
     */
    @Override
    public List<Spreadtree> selectSpreadtreeList(Spreadtree spreadtree)
    {
        return spreadtreeMapper.selectSpreadtreeList(spreadtree);
    }

    @Override
    public List<PersonInfo> selectDistinctPersonInfo(Spreadtree spreadtree) {
        return spreadtreeMapper.selectDistinctPersonInfo(spreadtree);
    }


    /**
     * 新增传播链条
     *
     * @param spreadtree 传播链条
     * @return 结果
     */
    @Override
    public int insertSpreadtree(Spreadtree spreadtree)
    {
        return spreadtreeMapper.insertSpreadtree(spreadtree);
    }

    /**
     * 修改传播链条
     *
     * @param spreadtree 传播链条
     * @return 结果
     */
    @Override
    public int updateSpreadtree(Spreadtree spreadtree)
    {
        return spreadtreeMapper.updateSpreadtree(spreadtree);
    }

    /**
     * 批量删除传播链条
     *
     * @param spreadtreeIds 需要删除的传播链条主键
     * @return 结果
     */
    @Override
    public int deleteSpreadtreeBySpreadtreeIds(Long[] spreadtreeIds)
    {
        return spreadtreeMapper.deleteSpreadtreeBySpreadtreeIds(spreadtreeIds);
    }

    /**
     * 删除传播链条信息
     *
     * @param spreadtreeId 传播链条主键
     * @return 结果
     */
    @Override
    public int deleteSpreadtreeBySpreadtreeId(Long spreadtreeId)
    {
        return spreadtreeMapper.deleteSpreadtreeBySpreadtreeId(spreadtreeId);
    }
}
