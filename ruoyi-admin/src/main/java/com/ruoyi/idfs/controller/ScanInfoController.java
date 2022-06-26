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
import com.ruoyi.system.domain.ScanInfo;
import com.ruoyi.system.service.IScanInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 扫码记录Controller
 *
 * @author SoLam
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/scanInfo")
@Api(tags = "扫码记录")
public class ScanInfoController extends BaseController
{
    @Autowired
    private IScanInfoService scanInfoService;

    /**
     * 查询扫码记录列表
     */
    @ApiOperation("查询扫码记录列表")
    @PreAuthorize("@ss.hasPermi('idfs:scanInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(ScanInfo scanInfo)
    {
        startPage();
        List<ScanInfo> list = scanInfoService.selectScanInfoList(scanInfo);
        return getDataTable(list);
    }

    /**
     * 导出扫码记录列表
     */
    @ApiOperation("导出扫码记录列表")
    @PreAuthorize("@ss.hasPermi('idfs:scanInfo:export')")
    @Log(title = "扫码记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ScanInfo scanInfo)
    {
        List<ScanInfo> list = scanInfoService.selectScanInfoList(scanInfo);
        ExcelUtil<ScanInfo> util = new ExcelUtil<ScanInfo>(ScanInfo.class);
        util.exportExcel(response, list, "扫码记录数据");
    }

    /**
     * 获取扫码记录详细信息
     */
    @ApiOperation("获取扫码记录详细信息")
    @PreAuthorize("@ss.hasPermi('idfs:scanInfo:query')")
    @GetMapping(value = "/{scanId}")
    public AjaxResult getInfo(@PathVariable("scanId") Long scanId)
    {
        return AjaxResult.success(scanInfoService.selectScanInfoByScanId(scanId));
    }

    /**
     * 新增扫码记录
     */
    @ApiOperation("新增扫码记录")
    @PreAuthorize("@ss.hasPermi('idfs:scanInfo:add')")
    @Log(title = "扫码记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScanInfo scanInfo)
    {
        return toAjax(scanInfoService.insertScanInfo(scanInfo));
    }

    /**
     * 修改扫码记录
     */
    @ApiOperation("修改扫码记录")
    @PreAuthorize("@ss.hasPermi('idfs:scanInfo:edit')")
    @Log(title = "扫码记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScanInfo scanInfo)
    {
        return toAjax(scanInfoService.updateScanInfo(scanInfo));
    }

    /**
     * 删除扫码记录
     */
    @ApiOperation("删除扫码记录")
    @PreAuthorize("@ss.hasPermi('idfs:scanInfo:remove')")
    @Log(title = "扫码记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{scanIds}")
    public AjaxResult remove(@PathVariable Long[] scanIds)
    {
        return toAjax(scanInfoService.deleteScanInfoByScanIds(scanIds));
    }
}
