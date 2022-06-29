package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 阳性人员途径地址信息对象 positive_travel
 * 
 * @author SoLam
 * @date 2022-06-27
 */
public class PositiveTravel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 阳性轨迹识别序号 */
    private Long travelId;

    /** 一次阳性人员轨迹记录对应同一个id */
    @Excel(name = "一次阳性人员轨迹记录对应同一个id")
    private Long recordId;

    /** 到达时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到达时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date arriveTime;

    /** 离开时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "离开时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date leftTime;

    /** 途径地址 */
    @Excel(name = "途径地址")
    private String address;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String peopleId;

    public void setTravelId(Long travelId) 
    {
        this.travelId = travelId;
    }

    public Long getTravelId() 
    {
        return travelId;
    }
    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }
    public void setArriveTime(Date arriveTime) 
    {
        this.arriveTime = arriveTime;
    }

    public Date getArriveTime() 
    {
        return arriveTime;
    }
    public void setLeftTime(Date leftTime) 
    {
        this.leftTime = leftTime;
    }

    public Date getLeftTime() 
    {
        return leftTime;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setPeopleId(String peopleId)
    {
        this.peopleId = peopleId;
    }

    public String getPeopleId()
    {
        return peopleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("travelId", getTravelId())
            .append("recordId", getRecordId())
            .append("arriveTime", getArriveTime())
            .append("leftTime", getLeftTime())
            .append("address", getAddress())
            .append("peopleId", getPeopleId())
            .toString();
    }
}
