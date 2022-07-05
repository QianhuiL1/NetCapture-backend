package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.PersonInfo;
import com.ruoyi.system.domain.ScanInfo;
import com.ruoyi.system.domain.Spreadtree;
import com.ruoyi.system.mapper.PersonInfoMapper;
import com.ruoyi.system.mapper.SpreadtreeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PositiveTravelMapper;
import com.ruoyi.system.domain.PositiveTravel;
import com.ruoyi.system.service.IPositiveTravelService;

/**
 * 阳性人员途径地址信息Service业务层处理
 * 
 * @author SoLam
 * @date 2022-06-27
 */
@Service
public class PositiveTravelServiceImpl implements IPositiveTravelService 
{
    @Autowired
    private PositiveTravelMapper positiveTravelMapper;

    @Autowired
    private SpreadtreeMapper spreadtreeMapper;

    @Autowired
    private PersonInfoMapper personInfoMapper;

    @Autowired
    private PersonInfoServiceImpl personInfoService;
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
     * 查询某人次阳性人员扫码记录列表
     *
     * @param recordId 某人次记录id
     * @return 某人次阳性人员扫码记录列表
     */
    @Override
    public List<ScanInfo> selectPositiveScanListByRecordId(String recordId) {
        return positiveTravelMapper.selectPositiveScanListByRecordId(recordId);
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
     * 根据recordId更新数据库中密切接触者的状态
     *
     * @param recordId 某人次记录id
     * @return 结果
     */
    public int updateContactStatusByPositiveTravel(String recordId)
    {
        List<String> peopleIds =  positiveTravelMapper.selectContactStatusByPositiveTravel(recordId);
        PositiveTravel positiveTravel = new PositiveTravel();
        positiveTravel.setRecordId(Long.parseLong(recordId));
        List<PositiveTravel> positiveTravels = positiveTravelMapper.selectPositiveTravelList(positiveTravel);
        if(peopleIds==null)
            return -1;
        else{
            if(positiveTravels==null)
                return 0;
            else
            {
                String dadId = positiveTravels.get(0).getPeopleId();
                for(String peopleId:peopleIds) {
                    if(peopleId.equals(dadId))
                    {
                    }
                    else{
                        PersonInfo personInfo = personInfoMapper.selectPersonInfoByPeopleId(peopleId);
                        if(personInfo.getStatus().equals("3"))
                        {
                        }
                        else {
                            personInfo.setStatus("2");
                            personInfoMapper.updatePersonInfo(personInfo);
                            Spreadtree spreadtree = new Spreadtree();
                            spreadtree.setDadId(dadId);
                            spreadtree.setSonId(peopleId);
                            spreadtree.setRelationship(0L);
                            spreadtreeMapper.insertSpreadtree(spreadtree);
                            personInfoService.updateSecondContactStatusByContact(personInfo.getPeopleId());
                        }

                    }
                }

        }



        }
        return 1;
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
