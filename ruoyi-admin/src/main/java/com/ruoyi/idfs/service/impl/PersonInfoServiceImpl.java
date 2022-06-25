package com.ruoyi.idfs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.idfs.mapper.PersonInfoMapper;
import com.ruoyi.idfs.domain.PersonInfo;
import com.ruoyi.idfs.service.IPersonInfoService;

/**
 * 存储普通人员的相关信息Service业务层处理
 * 
 * @author SoLam
 * @date 2022-06-25
 */
@Service
public class PersonInfoServiceImpl implements IPersonInfoService 
{
    @Autowired
    private PersonInfoMapper personInfoMapper;

    /**
     * 查询存储普通人员的相关信息
     * 
     * @param peopleId 存储普通人员的相关信息主键
     * @return 存储普通人员的相关信息
     */
    @Override
    public PersonInfo selectPersonInfoByPeopleId(String peopleId)
    {
        return personInfoMapper.selectPersonInfoByPeopleId(peopleId);
    }

    /**
     * 查询存储普通人员的相关信息列表
     * 
     * @param personInfo 存储普通人员的相关信息
     * @return 存储普通人员的相关信息
     */
    @Override
    public List<PersonInfo> selectPersonInfoList(PersonInfo personInfo)
    {
        return personInfoMapper.selectPersonInfoList(personInfo);
    }

    /**
     * 新增存储普通人员的相关信息
     * 
     * @param personInfo 存储普通人员的相关信息
     * @return 结果
     */
    @Override
    public int insertPersonInfo(PersonInfo personInfo)
    {
        return personInfoMapper.insertPersonInfo(personInfo);
    }

    /**
     * 修改存储普通人员的相关信息
     * 
     * @param personInfo 存储普通人员的相关信息
     * @return 结果
     */
    @Override
    public int updatePersonInfo(PersonInfo personInfo)
    {
        return personInfoMapper.updatePersonInfo(personInfo);
    }

    /**
     * 批量删除存储普通人员的相关信息
     * 
     * @param peopleIds 需要删除的存储普通人员的相关信息主键
     * @return 结果
     */
    @Override
    public int deletePersonInfoByPeopleIds(String[] peopleIds)
    {
        return personInfoMapper.deletePersonInfoByPeopleIds(peopleIds);
    }

    /**
     * 删除存储普通人员的相关信息信息
     * 
     * @param peopleId 存储普通人员的相关信息主键
     * @return 结果
     */
    @Override
    public int deletePersonInfoByPeopleId(String peopleId)
    {
        return personInfoMapper.deletePersonInfoByPeopleId(peopleId);
    }
}
