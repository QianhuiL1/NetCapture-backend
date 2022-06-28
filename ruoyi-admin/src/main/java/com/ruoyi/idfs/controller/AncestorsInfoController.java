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
import com.ruoyi.system.domain.AncestorsInfo;
import com.ruoyi.system.service.IAncestorsInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 行政区域Controller
 *
 * @author ruoyi
 * @date 2022-06-28
 */
@RestController
@Api(tags = "行政区划代码与风险等级")
@RequestMapping("/system/ancestor")
public class AncestorsInfoController extends BaseController
{
    @Autowired
    private IAncestorsInfoService ancestorsInfoService;

    /**
     * 查询行政区域列表
     */
    @ApiOperation("查询行政区域列表")
    @PreAuthorize("@ss.hasPermi('system:ancestor:list')")
    @GetMapping("/list")
    public TableDataInfo list(AncestorsInfo ancestorsInfo)
    {
        startPage();
        List<AncestorsInfo> list = ancestorsInfoService.selectAncestorsInfoList(ancestorsInfo);
        return getDataTable(list);
    }

    /**
     * 导出行政区域列表
     */
    @ApiOperation("导出行政区域列表")
    @PreAuthorize("@ss.hasPermi('system:ancestor:export')")
    @Log(title = "行政区域", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AncestorsInfo ancestorsInfo)
    {
        List<AncestorsInfo> list = ancestorsInfoService.selectAncestorsInfoList(ancestorsInfo);
        ExcelUtil<AncestorsInfo> util = new ExcelUtil<AncestorsInfo>(AncestorsInfo.class);
        util.exportExcel(response, list, "行政区域数据");
    }

    /**
     * 获取行政区域详细信息
     */
    @ApiOperation("获取行政区域详细信息")
    @PreAuthorize("@ss.hasPermi('system:ancestor:query')")
    @GetMapping(value = "/{ancestorId}")
    public AjaxResult getInfo(@PathVariable("ancestorId") String ancestorId)
    {
        return AjaxResult.success(ancestorsInfoService.selectAncestorsInfoByAncestorId(ancestorId));
    }

    /**
     * 新增行政区域
     */
    @ApiOperation("新增行政区域")
    @PreAuthorize("@ss.hasPermi('system:ancestor:add')")
    @Log(title = "行政区域", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AncestorsInfo ancestorsInfo)
    {
        return toAjax(ancestorsInfoService.insertAncestorsInfo(ancestorsInfo));
    }

    /**
     * 修改行政区域
     */
    @ApiOperation("修改行政区域")
    @PreAuthorize("@ss.hasPermi('system:ancestor:edit')")
    @Log(title = "行政区域", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AncestorsInfo ancestorsInfo)
    {
        return toAjax(ancestorsInfoService.updateAncestorsInfo(ancestorsInfo));
    }

    /**
     * 删除行政区域
     */
    @ApiOperation("删除行政区域")
    @PreAuthorize("@ss.hasPermi('system:ancestor:remove')")
    @Log(title = "行政区域", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ancestorIds}")
    public AjaxResult remove(@PathVariable String[] ancestorIds)
    {
        return toAjax(ancestorsInfoService.deleteAncestorsInfoByAncestorIds(ancestorIds));
    }
}
