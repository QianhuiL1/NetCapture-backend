package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SojournInfo;

/**
 * 旅居信息登记表Service接口
 *
 * @author ruoyi
 * @date 2022-06-27
 */
public interface ISojournInfoService
{
    /**
     * 查询旅居信息登记表
     *
     * @param sourjornId 旅居信息登记表主键
     * @return 旅居信息登记表
     */
    public SojournInfo selectSojournInfoBySourjornId(Long sourjornId);

    /**
     * 查询旅居信息登记表列表
     *
     * @param sojournInfo 旅居信息登记表
     * @return 旅居信息登记表集合
     */
    public List<SojournInfo> selectSojournInfoList(SojournInfo sojournInfo);

    /**
     * 根据身份证号查询旅居信息登记表列表
     *
     * @param peopleId 旅居信息登记表
     * @return 旅居信息登记表集合
     */
    public List<SojournInfo> selectSojournInfoListByPeopleId(String peopleId);

    /**
     * 新增旅居信息登记表
     *
     * @param sojournInfo 旅居信息登记表
     * @return 结果
     */
    public int insertSojournInfo(SojournInfo sojournInfo);

    /**
     * 修改旅居信息登记表
     *
     * @param sojournInfo 旅居信息登记表
     * @return 结果
     */
    public int updateSojournInfo(SojournInfo sojournInfo);

    /**
     * 批量删除旅居信息登记表
     *
     * @param sourjornIds 需要删除的旅居信息登记表主键集合
     * @return 结果
     */
    public int deleteSojournInfoBySourjornIds(Long[] sourjornIds);

    /**
     * 删除旅居信息登记表信息
     *
     * @param sourjornId 旅居信息登记表主键
     * @return 结果
     */
    public int deleteSojournInfoBySourjornId(Long sourjornId);
}
