package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.system.domain.Spreadtree;
import com.ruoyi.system.mapper.SpreadtreeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Literal;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PersonInfoMapper;
import com.ruoyi.system.domain.PersonInfo;
import com.ruoyi.system.service.IPersonInfoService;

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

    @Autowired
    private SpreadtreeMapper spreadtreeMapper;
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


    @Override
    public List<PersonInfo> selectPersonInfoListByStatus(String status)
    {
        return personInfoMapper.selectPersonInfoListByStatus(status);
    }

    @Override
    public List<PersonInfo> selectPersonInfolist(Date time1, Date time2) {
        return personInfoMapper.selectPersonInfolist(time1,time2);
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
     * 根据密接人员家庭地址更改次密接人员健康状况
     * @param dadId 父
     * @return
     */
    @Override
    public int updateSecondContactStatusByContact(String dadId) {
        PersonInfo dadInfo = personInfoMapper.selectPersonInfoByPeopleId(dadId);
        String address = dadInfo.getAddress();
        List<String> sonIds = personInfoMapper.selectSecondContactByContact(address);
        if(sonIds == null)
            return -1;
        else{
            for(String sonId:sonIds)
            {
                if(sonId.equals(dadId))
                {
                }
                else {
                    PersonInfo sonInfo = personInfoMapper.selectPersonInfoByPeopleId(sonId);
                    if(sonInfo.getStatus().equals("3")||sonInfo.getStatus().equals("2"))
                    {
                    }
                    else {
                        sonInfo.setStatus("1");
                        personInfoMapper.updatePersonInfo(sonInfo);
                        Spreadtree spreadtree = new Spreadtree();
                        spreadtree.setDadId(dadId);
                        spreadtree.setSonId(sonId);
                        spreadtree.setRelationship(1L);
                        spreadtreeMapper.insertSpreadtree(spreadtree);
                    }
                }
            }
            return 1;
        }
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
        if(personInfo.getStatus().equals("3"))
        {
            PersonInfo personInfoTemp = new PersonInfo();
            personInfoTemp.setAddress(personInfo.getAddress());
            List<PersonInfo> personInfo1 = personInfoMapper.selectPersonInfoList(personInfoTemp);
            for(PersonInfo pi:personInfo1)
            {
                pi.setStatus("2");
                personInfoMapper.updatePersonInfo(pi);
            }
        }
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
