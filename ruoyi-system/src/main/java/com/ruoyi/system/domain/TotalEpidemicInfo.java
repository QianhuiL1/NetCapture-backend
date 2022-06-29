package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 整体疫情对象 totalEpidemic_table
 * 
 * @author SoLam
 * @date 2022-06-29
 */
public class TotalEpidemicInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 地区 */
    @Excel(name = "地区")
    private String area;

    /** 总确诊人数 */
    @Excel(name = "总确诊人数")
    private Long confirm;

    /** 治愈人数 */
    @Excel(name = "治愈人数")
    private Long heal;

    /** 死亡人数 */
    @Excel(name = "死亡人数")
    private Long dead;

    /** 输入病例数 */
    @Excel(name = "输入病例数")
    private Long input;

    /** 最近一次更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最近一次更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastupdatetime;

    /** 总体疫情序号 */
    private Long totalepidemicid;

    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setConfirm(Long confirm) 
    {
        this.confirm = confirm;
    }

    public Long getConfirm() 
    {
        return confirm;
    }
    public void setHeal(Long heal) 
    {
        this.heal = heal;
    }

    public Long getHeal() 
    {
        return heal;
    }
    public void setDead(Long dead) 
    {
        this.dead = dead;
    }

    public Long getDead() 
    {
        return dead;
    }
    public void setInput(Long input) 
    {
        this.input = input;
    }

    public Long getInput() 
    {
        return input;
    }
    public void setLastupdatetime(Date lastupdatetime) 
    {
        this.lastupdatetime = lastupdatetime;
    }

    public Date getLastupdatetime() 
    {
        return lastupdatetime;
    }
    public void setTotalepidemicid(Long totalepidemicid) 
    {
        this.totalepidemicid = totalepidemicid;
    }

    public Long getTotalepidemicid() 
    {
        return totalepidemicid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("province", getProvince())
            .append("area", getArea())
            .append("confirm", getConfirm())
            .append("heal", getHeal())
            .append("dead", getDead())
            .append("input", getInput())
            .append("lastupdatetime", getLastupdatetime())
            .append("totalepidemicid", getTotalepidemicid())
            .toString();
    }
}