package com.ruoyi.system.mapper;

import java.util.Date;
import java.util.List;
import com.ruoyi.system.domain.PersonInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 存储普通人员的相关信息Mapper接口
 * 
 * @author SoLam
 * @date 2022-06-25
 */
@Repository
@Mapper
public interface PersonInfoMapper 
{
    /**
     * 查询存储普通人员的相关信息
     * 
     * @param peopleId 存储普通人员的相关信息主键
     * @return 存储普通人员的相关信息
     */
    public PersonInfo selectPersonInfoByPeopleId(String peopleId);


    /**
     * 查询存储普通人员的相关信息列表
     * 
     * @param personInfo 存储普通人员的相关信息
     * @return 存储普通人员的相关信息集合
     */
    public List<PersonInfo> selectPersonInfoList(PersonInfo personInfo);


    /**
     * 根据某一特定健康类型查询存储普通人员的相关信息列表
     *
     * @param status
     * @return 某一状态的储普通人员的相关信息集合
     */
    public List<PersonInfo> selectPersonInfoListByStatus(String status);

    /**
     * 根据时间段查询相关人员信息列表
     * @param time1
     * @param time2
     * @return
     */
    public List<PersonInfo> selectPersonInfolist(Date time1,Date time2);

    /**
     * 新增存储普通人员的相关信息
     * 
     * @param personInfo 存储普通人员的相关信息
     * @return 结果
     */
    public int insertPersonInfo(PersonInfo personInfo);

    /**
     * 修改存储普通人员的相关信息
     * 
     * @param personInfo 存储普通人员的相关信息
     * @return 结果
     */
    public int updatePersonInfo(PersonInfo personInfo);


    /**
     * 重置所有人员的健康状态
     * @return
     */
    public int statusEmpty();

    /**
     * 根据recordId更新数据库中密切接触者的状态
     *
     * @param address 某人次记录id
     * @return 结果
     */
    public List<String> selectSecondContactByContact(String address);
    /**
     * 删除存储普通人员的相关信息
     * 
     * @param peopleId 存储普通人员的相关信息主键
     * @return 结果
     */
    public int deletePersonInfoByPeopleId(String peopleId);

    /**
     * 批量删除存储普通人员的相关信息
     * 
     * @param peopleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePersonInfoByPeopleIds(String[] peopleIds);



}
