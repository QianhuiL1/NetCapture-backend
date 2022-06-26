package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PositiveTravel;
import org.apache.ibatis.annotations.Mapper;

/**
 * 阳性人员途径地址信息Mapper接口
 * 
 * @author SoLam
 * @date 2022-06-25
 */
@Mapper
public interface PositiveTravelMapper 
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
     * 新增阳性人员途径地址信息
     * 
     * @param positiveTravel 阳性人员途径地址信息
     * @return 结果
     */
    public int insertPositiveTravel(PositiveTravel positiveTravel);

    /**
     * 修改阳性人员途径地址信息
     * 
     * @param positiveTravel 阳性人员途径地址信息
     * @return 结果
     */
    public int updatePositiveTravel(PositiveTravel positiveTravel);

    /**
     * 删除阳性人员途径地址信息
     * 
     * @param travelId 阳性人员途径地址信息主键
     * @return 结果
     */
    public int deletePositiveTravelByTravelId(Long travelId);

    /**
     * 批量删除阳性人员途径地址信息
     * 
     * @param travelIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePositiveTravelByTravelIds(Long[] travelIds);
}