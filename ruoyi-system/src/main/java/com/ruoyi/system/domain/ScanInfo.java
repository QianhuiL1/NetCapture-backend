package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 扫码记录对象 scan_table
 *
 * @author SoLam
 * @date 2022-06-25
 */
public class ScanInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 扫码信息识别序号 */
    private Long scanId;

    /** 身份证号码 */
    @Excel(name = "身份证号码")
    private String peopleId;

    /** 扫码时间 */
    @Excel(name = "扫码时间")
    private String time;

    /** 扫码地址 */
    @Excel(name = "扫码地址")
    private String address;

    public void setScanId(Long scanId)
    {
        this.scanId = scanId;
    }

    public Long getScanId()
    {
        return scanId;
    }
    public void setPeopleId(String peopleId)
    {
        this.peopleId = peopleId;
    }

    public String getPeopleId()
    {
        return peopleId;
    }
    public void setTime(String time)
    {
        this.time = time;
    }

    public String getTime()
    {
        return time;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("scanId", getScanId())
            .append("peopleId", getPeopleId())
            .append("time", getTime())
            .append("address", getAddress())
            .toString();
    }
}
