package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 疫情新闻对象 epedemicEvent_table
 * 
 * @author SoLam
 * @date 2022-06-30
 */
public class EpedemicEventInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 新闻描述 */
    @Excel(name = "新闻描述")
    private String eventdescription;

    /** 新闻网址 */
    @Excel(name = "新闻网址")
    private String eventurl;

    /** 新闻发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "新闻发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date eventtime;

    /** 新闻序号 */
    private Long eventid;

    public void setEventdescription(String eventdescription) 
    {
        this.eventdescription = eventdescription;
    }

    public String getEventdescription() 
    {
        return eventdescription;
    }
    public void setEventurl(String eventurl) 
    {
        this.eventurl = eventurl;
    }

    public String getEventurl() 
    {
        return eventurl;
    }
    public void setEventtime(Date eventtime) 
    {
        this.eventtime = eventtime;
    }

    public Date getEventtime() 
    {
        return eventtime;
    }
    public void setEventid(Long eventid) 
    {
        this.eventid = eventid;
    }

    public Long getEventid() 
    {
        return eventid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("eventdescription", getEventdescription())
            .append("eventurl", getEventurl())
            .append("eventtime", getEventtime())
            .append("eventid", getEventid())
            .toString();
    }
}
