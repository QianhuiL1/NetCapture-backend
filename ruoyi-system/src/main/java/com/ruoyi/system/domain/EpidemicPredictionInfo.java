package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 疫情预测对象 epidemicPrediction_table
 * 
 * @author SoLam
 * @date 2022-06-30
 */
public class EpidemicPredictionInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 省份名 */
    @Excel(name = "省份名")
    private String name;

    /** 预测日期 */
    @Excel(name = "预测日期")
    private String date;

    /** 预测新增病例 */
    @Excel(name = "预测新增病例")
    private String newDailyData;

    /** 预测新增病例最高值 */
    @Excel(name = "预测新增病例最高值")
    private String newDailyHigh;

    /** 预测新增病例最低值 */
    @Excel(name = "预测新增病例最低值")
    private String newDailyLow;

    /** 疫情预测表序号 */
    private Long id;

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDate(String date) 
    {
        this.date = date;
    }

    public String getDate() 
    {
        return date;
    }
    public void setNewDailyData(String newDailyData) 
    {
        this.newDailyData = newDailyData;
    }

    public String getNewDailyData() 
    {
        return newDailyData;
    }
    public void setNewDailyHigh(String newDailyHigh) 
    {
        this.newDailyHigh = newDailyHigh;
    }

    public String getNewDailyHigh() 
    {
        return newDailyHigh;
    }
    public void setNewDailyLow(String newDailyLow) 
    {
        this.newDailyLow = newDailyLow;
    }

    public String getNewDailyLow() 
    {
        return newDailyLow;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("name", getName())
            .append("date", getDate())
            .append("newDailyData", getNewDailyData())
            .append("newDailyHigh", getNewDailyHigh())
            .append("newDailyLow", getNewDailyLow())
            .append("id", getId())
            .toString();
    }
}
