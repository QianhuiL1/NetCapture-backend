package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 风险地区对象 riskArea_table
 * 
 * @author SoLam
 * @date 2022-07-06
 */
public class RiskAreaInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 风险地区 */
    @Excel(name = "风险地区")
    private String area;

    /** 具体地址 */
    @Excel(name = "具体地址")
    private String address;

    /** 风险等级 */
    @Excel(name = "风险等级")
    private String risklevel;

    /** 最近一次更新时间 */
    @Excel(name = "最近一次更新时间")
    private String lastupdatetime;

    /** 风险地区序号 */
    private Long riskareaid;

    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setRisklevel(String risklevel) 
    {
        this.risklevel = risklevel;
    }

    public String getRisklevel() 
    {
        return risklevel;
    }
    public void setLastupdatetime(String lastupdatetime) 
    {
        this.lastupdatetime = lastupdatetime;
    }

    public String getLastupdatetime() 
    {
        return lastupdatetime;
    }
    public void setRiskareaid(Long riskareaid) 
    {
        this.riskareaid = riskareaid;
    }

    public Long getRiskareaid() 
    {
        return riskareaid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("area", getArea())
            .append("address", getAddress())
            .append("risklevel", getRisklevel())
            .append("lastupdatetime", getLastupdatetime())
            .append("riskareaid", getRiskareaid())
            .toString();
    }
}
