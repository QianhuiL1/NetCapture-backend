package com.ruoyi.idfs.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.TodayEpidemicInfo;
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
import com.ruoyi.system.domain.TotalEpidemicInfo;
import com.ruoyi.system.service.ITotalEpidemicInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 整体疫情Controller
 *
 * @author SoLam
 * @date 2022-06-29
 */
@RestController
@RequestMapping("/totalEpidemic")
@Api(tags = "整体疫情")
public class TotalEpidemicInfoController extends BaseController
{
    @Autowired
    private ITotalEpidemicInfoService totalEpidemicInfoService;

    /**
     * 查询整体疫情列表
     */
    @PreAuthorize("@ss.hasPermi('system:totalEpidemic:list')")
    @GetMapping("/list")
    @ApiOperation("查询整体疫情列表")
    public TableDataInfo list(TotalEpidemicInfo totalEpidemicInfo)
    {
        startPage();
        List<TotalEpidemicInfo> list = totalEpidemicInfoService.selectTotalEpidemicInfoList(totalEpidemicInfo);
        return getDataTable(list);
    }

    /**
     * 导出整体疫情列表
     */
    @PreAuthorize("@ss.hasPermi('system:totalEpidemic:export')")
    @Log(title = "整体疫情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ApiOperation("导出整体疫情列表")
    public void export(HttpServletResponse response, TotalEpidemicInfo totalEpidemicInfo)
    {
        List<TotalEpidemicInfo> list = totalEpidemicInfoService.selectTotalEpidemicInfoList(totalEpidemicInfo);
        ExcelUtil<TotalEpidemicInfo> util = new ExcelUtil<TotalEpidemicInfo>(TotalEpidemicInfo.class);
        util.exportExcel(response, list, "整体疫情数据");
    }

    /**
     * 获取整体疫情详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:totalEpidemic:query')")
    @GetMapping(value = "/{totalepidemicid}")
    @ApiOperation("获取整体疫情详细信息")
    public AjaxResult getInfo(@PathVariable("totalepidemicid") Long totalepidemicid)
    {
        return AjaxResult.success(totalEpidemicInfoService.selectTotalEpidemicInfoByTotalepidemicid(totalepidemicid));
    }

    /**
     * 新增整体疫情
     */
    @PreAuthorize("@ss.hasPermi('system:totalEpidemic:add')")
    @Log(title = "整体疫情", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增整体疫情")
    public AjaxResult add(@RequestBody TotalEpidemicInfo totalEpidemicInfo)
    {
        return toAjax(totalEpidemicInfoService.insertTotalEpidemicInfo(totalEpidemicInfo));
    }

    /**
     * 修改整体疫情
     */
    @PreAuthorize("@ss.hasPermi('system:totalEpidemic:edit')")
    @Log(title = "整体疫情", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("修改整体疫情")
    public AjaxResult edit(@RequestBody TotalEpidemicInfo totalEpidemicInfo)
    {
        return toAjax(totalEpidemicInfoService.updateTotalEpidemicInfo(totalEpidemicInfo));
    }

    /**
     * 删除整体疫情
     */
    @PreAuthorize("@ss.hasPermi('system:totalEpidemic:remove')")
    @Log(title = "整体疫情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{totalepidemicids}")
    @ApiOperation("删除整体疫情")
    public AjaxResult remove(@PathVariable Long[] totalepidemicids)
    {
        return toAjax(totalEpidemicInfoService.deleteTotalEpidemicInfoByTotalepidemicids(totalepidemicids));
    }

    /**
     * 查询整体省份疫情列表
     */
    @PreAuthorize("@ss.hasPermi('system:todayEpidemic:provinceList')")
    @GetMapping("/provinceList")
    @ApiOperation("查询整体省份疫情列表")
    public TableDataInfo provinceList()
    {
        startPage();
        List<TotalEpidemicInfo> list = totalEpidemicInfoService.selectTotalProvinceEpidemicInfoList();
        return getDataTable(list);
    }

}
