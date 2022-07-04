package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 传播链条对象 spreadtree
 *
 * @author Martin
 * @date 2022-07-04
 */
public class Spreadtree extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 传播链id */
    @Excel(name = "传播链id")
    private Long spreadtreeId;

    /** 被动方身份证号 */
    @Excel(name = "被动方身份证号")
    private String sonId;

    /** 主动方身份证号 */
    @Excel(name = "主动方身份证号")
    private String dadId;

    /** 0直接接触成密接
     1间接接触成次密接 */
    @Excel(name = "0直接接触成密接  1间接接触成次密接")

            private Long relationship;

            public void setSpreadtreeId(Long spreadtreeId)
    {
        this.spreadtreeId = spreadtreeId;
    }

    public Long getSpreadtreeId()
    {
        return spreadtreeId;
    }
    public void setSonId(String sonId)
    {
        this.sonId = sonId;
    }

    public String getSonId()
    {
        return sonId;
    }
    public void setDadId(String dadId)
    {
        this.dadId = dadId;
    }

    public String getDadId()
    {
        return dadId;
    }
    public void setRelationship(Long relationship)
    {
        this.relationship = relationship;
    }

    public Long getRelationship()
    {
        return relationship;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("spreadtreeId", getSpreadtreeId())
                .append("sonId", getSonId())
                .append("dadId", getDadId())
                .append("relationship", getRelationship())
                .toString();
    }
}
