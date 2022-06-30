package com.ruoyi.idfs.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.EpedemicEventInfo;
import com.ruoyi.system.service.IEpedemicEventInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 疫情新闻Controller
 *
 * @author SoLam
 * @date 2022-06-30
 */
@RestController
@RequestMapping("/epidemicEvent")
@Api(tags = "疫情新闻")
public class EpedemicEventInfoController extends BaseController
{
    @Autowired
    private IEpedemicEventInfoService epedemicEventInfoService;

    /**
     * 查询疫情新闻列表
     */
    @PreAuthorize("@ss.hasPermi('system:epidemicEvent:list')")
    @GetMapping("/list")
    @ApiOperation("查询疫情新闻列表")
    public TableDataInfo list()
    {
        //startPage();
        List<EpedemicEventInfo> list = epedemicEventInfoService.selectEpedemicEventInfoList();
        return getDataTable(list);
    }

    /**
     * 获取疫情新闻详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:epidemicEvent:query')")
    @GetMapping(value = "/{eventid}")
    @ApiOperation("获取疫情新闻详细信息")
    public AjaxResult getInfo(@PathVariable("eventid") Long eventid)
    {
        return AjaxResult.success(epedemicEventInfoService.selectEpedemicEventInfoByEventid(eventid));
    }

    /**
     * 新增疫情新闻
     */
    @PreAuthorize("@ss.hasPermi('system:epidemicEvent:add')")
    @Log(title = "疫情新闻", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增疫情新闻")
    public AjaxResult add(@RequestBody EpedemicEventInfo epedemicEventInfo)
    {
        return toAjax(epedemicEventInfoService.insertEpedemicEventInfo(epedemicEventInfo));
    }

    /**
     * 修改疫情新闻
     */
    @PreAuthorize("@ss.hasPermi('system:epidemicEvent:edit')")
    @Log(title = "疫情新闻", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("修改疫情新闻")
    public AjaxResult edit(@RequestBody EpedemicEventInfo epedemicEventInfo)
    {
        return toAjax(epedemicEventInfoService.updateEpedemicEventInfo(epedemicEventInfo));
    }

    /**
     * 删除疫情新闻
     */
    @PreAuthorize("@ss.hasPermi('system:epidemicEvent:remove')")
    @Log(title = "疫情新闻", businessType = BusinessType.DELETE)
	@DeleteMapping("/{eventids}")
    @ApiOperation("删除疫情新闻")
    public AjaxResult remove(@PathVariable Long[] eventids)
    {
        return toAjax(epedemicEventInfoService.deleteEpedemicEventInfoByEventids(eventids));
    }
}
