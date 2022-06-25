package com.ruoyi.idfs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.idfs.mapper.PositiveTravelMapper;
import com.ruoyi.idfs.domain.PositiveTravel;
import com.ruoyi.idfs.service.IPositiveTravelService;

/**
 * 阳性人员途径地址信息Service业务层处理
 * 
 * @author SoLam
 * @date 2022-06-25
 */
@Service
public class PositiveTravelServiceImpl implements IPositiveTravelService 
{
    @Autowired
    private PositiveTravelMapper positiveTravelMapper;

    /**
     * 查询阳性人员途径地址信息
     * 
     * @param travelId 阳性人员途径地址信息主键
     * @return 阳性人员途径地址信息
     */
    @Override
    public PositiveTravel selectPositiveTravelByTravelId(Long travelId)
    {
        return positiveTravelMapper.selectPositiveTravelByTravelId(travelId);
    }

    /**
     * 查询阳性人员途径地址信息列表
     * 
     * @param positiveTravel 阳性人员途径地址信息
     * @return 阳性人员途径地址信息
     */
    @Override
    public List<PositiveTravel> selectPositiveTravelList(PositiveTravel positiveTravel)
    {
        return positiveTravelMapper.selectPositiveTravelList(positiveTravel);
    }

    /**
     * 新增阳性人员途径地址信息
     * 
     * @param positiveTravel 阳性人员途径地址信息
     * @return 结果
     */
    @Override
    public int insertPositiveTravel(PositiveTravel positiveTravel)
    {
        return positiveTravelMapper.insertPositiveTravel(positiveTravel);
    }

    /**
     * 修改阳性人员途径地址信息
     * 
     * @param positiveTravel 阳性人员途径地址信息
     * @return 结果
     */
    @Override
    public int updatePositiveTravel(PositiveTravel positiveTravel)
    {
        return positiveTravelMapper.updatePositiveTravel(positiveTravel);
    }

    /**
     * 批量删除阳性人员途径地址信息
     * 
     * @param travelIds 需要删除的阳性人员途径地址信息主键
     * @return 结果
     */
    @Override
    public int deletePositiveTravelByTravelIds(Long[] travelIds)
    {
        return positiveTravelMapper.deletePositiveTravelByTravelIds(travelIds);
    }

    /**
     * 删除阳性人员途径地址信息信息
     * 
     * @param travelId 阳性人员途径地址信息主键
     * @return 结果
     */
    @Override
    public int deletePositiveTravelByTravelId(Long travelId)
    {
        return positiveTravelMapper.deletePositiveTravelByTravelId(travelId);
    }
}
