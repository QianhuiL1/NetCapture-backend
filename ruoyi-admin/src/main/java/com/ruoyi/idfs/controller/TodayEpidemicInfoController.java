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
import com.ruoyi.system.domain.TodayEpidemicInfo;
import com.ruoyi.system.service.ITodayEpidemicInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 当天疫情Controller
 *
 * @author SoLam
 * @date 2022-06-29
 */
@RestController
@RequestMapping("/todayEpidemic")
@Api(tags = "当天疫情")
public class TodayEpidemicInfoController extends BaseController
{
    @Autowired
    private ITodayEpidemicInfoService todayEpidemicInfoService;

    /**
     * 查询当天疫情列表
     */
    @PreAuthorize("@ss.hasPermi('system:todayEpidemic:list')")
    @GetMapping("/list")
    @ApiOperation("查询当天疫情列表")
    public TableDataInfo list(TodayEpidemicInfo todayEpidemicInfo)
    {
        startPage();
        List<TodayEpidemicInfo> list = todayEpidemicInfoService.selectTodayEpidemicInfoList(todayEpidemicInfo);
        return getDataTable(list);
    }

    /**
     * 导出当天疫情列表
     */
    @PreAuthorize("@ss.hasPermi('system:todayEpidemic:export')")
    @Log(title = "当天疫情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ApiOperation("导出当天疫情列表")
    public void export(HttpServletResponse response, TodayEpidemicInfo todayEpidemicInfo)
    {
        List<TodayEpidemicInfo> list = todayEpidemicInfoService.selectTodayEpidemicInfoList(todayEpidemicInfo);
        ExcelUtil<TodayEpidemicInfo> util = new ExcelUtil<TodayEpidemicInfo>(TodayEpidemicInfo.class);
        util.exportExcel(response, list, "当天疫情数据");
    }

    /**
     * 获取当天疫情详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:todayEpidemic:query')")
    @GetMapping(value = "/{todayepidemicid}")
    @ApiOperation("获取当天疫情详细信息")
    public AjaxResult getInfo(@PathVariable("todayepidemicid") Long todayepidemicid)
    {
        return AjaxResult.success(todayEpidemicInfoService.selectTodayEpidemicInfoByTodayepidemicid(todayepidemicid));
    }

    /**
     * 新增当天疫情
     */
    @PreAuthorize("@ss.hasPermi('system:todayEpidemic:add')")
    @Log(title = "当天疫情", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增当天疫情")
    public AjaxResult add(@RequestBody TodayEpidemicInfo todayEpidemicInfo)
    {
        return toAjax(todayEpidemicInfoService.insertTodayEpidemicInfo(todayEpidemicInfo));
    }

    /**
     * 修改当天疫情
     */
    @PreAuthorize("@ss.hasPermi('system:todayEpidemic:edit')")
    @Log(title = "当天疫情", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("修改当天疫情")
    public AjaxResult edit(@RequestBody TodayEpidemicInfo todayEpidemicInfo)
    {
        return toAjax(todayEpidemicInfoService.updateTodayEpidemicInfo(todayEpidemicInfo));
    }

    /**
     * 删除当天疫情
     */
    @PreAuthorize("@ss.hasPermi('system:todayEpidemic:remove')")
    @Log(title = "当天疫情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{todayepidemicids}")
    @ApiOperation("删除当天疫情")
    public AjaxResult remove(@PathVariable Long[] todayepidemicids)
    {
        return toAjax(todayEpidemicInfoService.deleteTodayEpidemicInfoByTodayepidemicids(todayepidemicids));
    }

    /**
     * 查询当天省份疫情列表
     */
    @PreAuthorize("@ss.hasPermi('system:todayEpidemic:provinceList')")
    @GetMapping("/provinceList")
    @ApiOperation("查询当天省份疫情列表")
    public TableDataInfo provinceList()
    {
        startPage();
        List<TodayEpidemicInfo> list = todayEpidemicInfoService.selectTodayProvinceEpidemicInfoList();
        return getDataTable(list);
    }
}
