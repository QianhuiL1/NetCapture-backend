package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PositiveTravel;
import com.ruoyi.system.domain.ScanInfo;

/**
 * 阳性人员途径地址信息Service接口
 * 
 * @author SoLam
 * @date 2022-06-27
 */
public interface IPositiveTravelService 
{
    /**
     * 查询阳性人员途径地址信息
     * 
     * @param travelId 阳性人员途径地址信息主键
     * @return 阳性人员途径地址信息
     */
    public PositiveTravel selectPositiveTravelByTravelId(Long travelId);

    /**
     * 查询阳性人员途径地址信息列表
     * 
     * @param positiveTravel 阳性人员途径地址信息
     * @return 阳性人员途径地址信息集合
     */
    public List<PositiveTravel> selectPositiveTravelList(PositiveTravel positiveTravel);

    /**
     * 查询某人次阳性人员扫码记录列表
     *
     * @param recordId 某人次记录id
     * @return 某人次阳性人员扫码记录列表
     */
    public List<ScanInfo> selectPositiveScanListByRecordId(String recordId);

    /**
     * 新增阳性人员途径地址信息
     * 
     * @param positiveTravel 阳性人员途径地址信息
     * @return 结果
     */
    public int insertPositiveTravel(PositiveTravel positiveTravel);

    /**
     * 根据recordId更新数据库中密切接触者的状态
     *
     *
     */
    public int updateContactStatusByPositiveTravel(String recordId);

    /**
     * 修改阳性人员途径地址信息
     * 
     * @param positiveTravel 阳性人员途径地址信息
     * @return 结果
     */
    public int updatePositiveTravel(PositiveTravel positiveTravel);

    /**
     * 批量删除阳性人员途径地址信息
     * 
     * @param travelIds 需要删除的阳性人员途径地址信息主键集合
     * @return 结果
     */
    public int deletePositiveTravelByTravelIds(Long[] travelIds);

    /**
     * 删除阳性人员途径地址信息信息
     * 
     * @param travelId 阳性人员途径地址信息主键
     * @return 结果
     */
    public int deletePositiveTravelByTravelId(Long travelId);
}
