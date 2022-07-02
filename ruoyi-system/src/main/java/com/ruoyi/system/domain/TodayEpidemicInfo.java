package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 当天疫情对象 todayEpidemic_table
 *
 * @author SoLam
 * @date 2022-06-29
 */
public class TodayEpidemicInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 国家 */
    @Excel(name = "国家")
    private String country;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 地区 */
    @Excel(name = "地区")
    private String area;

    /** 总确诊人数 */
    @Excel(name = "总确诊人数")
    private Long confirm;

    /** 现有确诊人数 */
    @Excel(name = "现有确诊人数")
    private Long storeconfirm;

    /** 治愈人数 */
    @Excel(name = "治愈人数")
    private Long heal;

    /** 死亡人数 */
    @Excel(name = "死亡人数")
    private Long dead;

    /** 最近一次更新时间 */
    @Excel(name = "最近一次更新时间")
    private String lastupdatetime;

    /** 输入病例 */
    @Excel(name = "输入病例")
    private Long input;

    /** 新增无症状感染者 */
    @Excel(name = "新增无症状感染者")
    private Long incrNoSymptom;

    /** 当天疫情序号 */
    private Long todayepidemicid;

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
    public void setStoreconfirm(Long storeconfirm)
    {
        this.storeconfirm = storeconfirm;
    }

    public Long getStoreconfirm()
    {
        return storeconfirm;
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
    public void setLastupdatetime(String lastupdatetime)
    {
        this.lastupdatetime = lastupdatetime;
    }

    public String getLastupdatetime()
    {
        return lastupdatetime;
    }
    public void setTodayepidemicid(Long todayepidemicid)
    {
        this.todayepidemicid = todayepidemicid;
    }

    public Long getTodayepidemicid()
    {
        return todayepidemicid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getInput() {
        return input;
    }

    public void setInput(Long input) {
        this.input = input;
    }

    public Long getIncrNoSymptom() {
        return incrNoSymptom;
    }

    public void setIncrNoSymptom(Long incrNoSymptom) {
        this.incrNoSymptom = incrNoSymptom;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("province", getProvince())
            .append("area", getArea())
            .append("confirm", getConfirm())
            .append("storeconfirm", getStoreconfirm())
            .append("heal", getHeal())
            .append("dead", getDead())
            .append("lastupdatetime", getLastupdatetime())
            .append("todayepidemicid", getTodayepidemicid())
                .append("input",getInput())
                .append("country",getCountry())
                .append("incrNoSymptom",getIncrNoSymptom())
            .toString();
    }
}
