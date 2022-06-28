package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 行政区域对象 ancestors_table
 *
 * @author ruoyi
 * @date 2022-06-28
 */
public class AncestorsInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 行政区域编码 */
    private String ancestorId;

    /** 行政区域名称 */
    @Excel(name = "行政区域名称")
    private String name;

    /** 行政区域风险分级 */
    @Excel(name = "行政区域风险分级")
    private Long status;

    public void setAncestorId(String ancestorId)
    {
        this.ancestorId = ancestorId;
    }

    public String getAncestorId()
    {
        return ancestorId;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("ancestorId", getAncestorId())
                .append("name", getName())
                .append("status", getStatus())
                .toString();
    }
}
