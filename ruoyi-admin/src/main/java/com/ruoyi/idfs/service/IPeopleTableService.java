package com.ruoyi.idfs.service;


import java.util.List;
import com.ruoyi.idfs.domain.PeopleTable;

/**
 * 存储普通人员的相关信息Service接口
 *
 * @author ruoyi
 * @date 2022-06-25
 */
public interface IPeopleTableService
{
    /**
     * 查询存储普通人员的相关信息
     *
     * @param peopleId 存储普通人员的相关信息主键
     * @return 存储普通人员的相关信息
     */
    public PeopleTable selectPeopleTableByPeopleId(String peopleId);

    /**
     * 查询存储普通人员的相关信息列表
     *
     * @param peopleTable 存储普通人员的相关信息
     * @return 存储普通人员的相关信息集合
     */
    public List<PeopleTable> selectPeopleTableList(PeopleTable peopleTable);

    /**
     * 新增存储普通人员的相关信息
     *
     * @param peopleTable 存储普通人员的相关信息
     * @return 结果
     */
    public int insertPeopleTable(PeopleTable peopleTable);

    /**
     * 修改存储普通人员的相关信息
     *
     * @param peopleTable 存储普通人员的相关信息
     * @return 结果
     */
    public int updatePeopleTable(PeopleTable peopleTable);

    /**
     * 批量删除存储普通人员的相关信息
     *
     * @param peopleIds 需要删除的存储普通人员的相关信息主键集合
     * @return 结果
     */
    public int deletePeopleTableByPeopleIds(String[] peopleIds);

    /**
     * 删除存储普通人员的相关信息信息
     *
     * @param peopleId 存储普通人员的相关信息主键
     * @return 结果
     */
    public int deletePeopleTableByPeopleId(String peopleId);
}

