package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 旅居信息登记表对象 sojourn_table
 *
 * @author ruoyi
 * @date 2022-06-27
 */
public class SojournInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    private PersonInfo personInfo;

    /** 旅居记录id */
    private Long sojournId;

    /** 人员id */
    @Excel(name = "人员id")
    private String peopleId;

    /** 来源地行政编码 */
    @Excel(name = "来源地行政编码")
    private String fromAncestors;

    /** 目的地行政编码 */
    @Excel(name = "目的地行政编码")
    private String toAncestors;


    /** 登记时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "登记时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recordTime;


    /** 目的地详细地址 */
    @Excel(name = "目的地详细地址")
    private String toAddress;

    /** 交通方式 */
    @Excel(name = "交通方式")
    private String transportation;

    public void setSourjornId(Long sourjornId)
    {
        this.sojournId = sourjornId;
    }

    public Long getSourjornId()
    {
        return sojournId;
    }
    public void setPeopleId(String peopleId)
    {
        this.peopleId = peopleId;
    }

    public String getPeopleId()
    {
        return peopleId;
    }
    public void setFromAncestors(String fromAncestors)
    {
        this.fromAncestors = fromAncestors;
    }

    public String getFromAncestors()
    {
        return fromAncestors;
    }
    public void setToAncestors(String toAncestors)
    {
        this.toAncestors = toAncestors;
    }

    public String getToAncestors()
    {
        return toAncestors;
    }
    public void setRecordTime(Date recordTime)
    {
        this.recordTime = recordTime;
    }

    public Date getRecordTime()
    {
        return recordTime;
    }

    public void setToAddress(String toAddress)
    {
        this.toAddress = toAddress;
    }

    public String getToAddress()
    {
        return toAddress;
    }

    public void setTransportation(String transportation)
    {
        this.transportation = transportation;
    }

    public String getTransportation()
    {
        return transportation;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("sourjornId", getSourjornId())
                .append("peopleId", getPeopleId())
                .append("fromAncestors", getFromAncestors())
                .append("toAncestors", getToAncestors())
                .append("recordTime", getRecordTime())
                .append("toAddress", getToAddress())
                .append("transportation",getTransportation())
                .toString();
    }
}
