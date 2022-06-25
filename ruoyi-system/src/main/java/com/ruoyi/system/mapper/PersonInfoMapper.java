package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PersonInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 存储普通人员的相关信息Mapper接口
 * 
 * @author SoLam
 * @date 2022-06-25
 */
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
     * @param personInfo 存储普通人员的相关信息
     * @param status
     * @return 某一状态的储普通人员的相关信息集合
     */
    public List<PersonInfo> selectPersonInfoListByStatus(PersonInfo personInfo,int status);

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
