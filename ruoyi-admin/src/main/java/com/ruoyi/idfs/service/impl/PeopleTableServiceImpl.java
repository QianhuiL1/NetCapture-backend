package com.ruoyi.idfs.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.idfs.mapper.PeopleTableMapper;
import com.ruoyi.idfs.domain.PeopleTable;
import com.ruoyi.idfs.service.IPeopleTableService;

/**
 * 存储普通人员的相关信息Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-25
 */
@Service
public class PeopleTableServiceImpl implements IPeopleTableService
{
    @Autowired
    private PeopleTableMapper peopleTableMapper;

    /**
     * 查询存储普通人员的相关信息
     *
     * @param peopleId 存储普通人员的相关信息主键
     * @return 存储普通人员的相关信息
     */
    @Override
    public PeopleTable selectPeopleTableByPeopleId(String peopleId)
    {
        return peopleTableMapper.selectPeopleTableByPeopleId(peopleId);
    }

    /**
     * 查询存储普通人员的相关信息列表
     *
     * @param peopleTable 存储普通人员的相关信息
     * @return 存储普通人员的相关信息
     */
    @Override
    public List<PeopleTable> selectPeopleTableList(PeopleTable peopleTable)
    {
        return peopleTableMapper.selectPeopleTableList(peopleTable);
    }

    /**
     * 新增存储普通人员的相关信息
     *
     * @param peopleTable 存储普通人员的相关信息
     * @return 结果
     */
    @Override
    public int insertPeopleTable(PeopleTable peopleTable)
    {
        return peopleTableMapper.insertPeopleTable(peopleTable);
    }

    /**
     * 修改存储普通人员的相关信息
     *
     * @param peopleTable 存储普通人员的相关信息
     * @return 结果
     */
    @Override
    public int updatePeopleTable(PeopleTable peopleTable)
    {
        return peopleTableMapper.updatePeopleTable(peopleTable);
    }

    /**
     * 批量删除存储普通人员的相关信息
     *
     * @param peopleIds 需要删除的存储普通人员的相关信息主键
     * @return 结果
     */
    @Override
    public int deletePeopleTableByPeopleIds(String[] peopleIds)
    {
        return peopleTableMapper.deletePeopleTableByPeopleIds(peopleIds);
    }

    /**
     * 删除存储普通人员的相关信息信息
     *
     * @param peopleId 存储普通人员的相关信息主键
     * @return 结果
     */
    @Override
    public int deletePeopleTableByPeopleId(String peopleId)
    {
        return peopleTableMapper.deletePeopleTableByPeopleId(peopleId);
    }
}

