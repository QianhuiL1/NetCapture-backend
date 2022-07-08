package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 存储普通人员的相关信息对象 people_table
 *
 * @author SoLam
 * @date 2022-06-25
 */
public class PersonInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 身份证号码 */
    private String people_id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 0:女1：男 */
    @Excel(name = "0:女 1：男")
    private String sex;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phonenumber;

    /** 0：健康
        1：次密接
        2：密接
        3：阳性 */
    @Excel(name = "0：健康 1：次密接 2：密接 3：阳性")
    private String status;

    /** 祖级列表 */
    @Excel(name = "祖级列表")
    private String ancestors;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date positiveTime;




    public void setPeople_id(String people_id)
    {
        this.people_id = people_id;
    }

    public String getPeople_id()
    {
        return people_id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setAncestors(String ancestors)
    {
        this.ancestors = ancestors;
    }

    public String getAncestors()
    {
        return ancestors;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }

    public void setPositiveTime(Date positiveTime)
    {
        this.positiveTime = positiveTime;
    }

    public Date getPositiveTime()
    {
        return positiveTime;
    }




    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("people_id", getPeople_id())
            .append("name", getName())
            .append("sex", getSex())
            .append("phonenumber", getPhonenumber())
            .append("status", getStatus())
            .append("ancestors", getAncestors())
            .append("address", getAddress())
            .append("positiveTime", getPositiveTime())
            .toString();
    }
}
