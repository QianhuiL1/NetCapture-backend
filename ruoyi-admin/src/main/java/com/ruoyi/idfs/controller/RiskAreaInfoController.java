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
import com.ruoyi.system.domain.RiskAreaInfo;
import com.ruoyi.system.service.IRiskAreaInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 风险地区Controller
 *
 * @author SoLam
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/riskArea")
@Api(tags = "风险地区")
public class RiskAreaInfoController extends BaseController
{
    @Autowired
    private IRiskAreaInfoService riskAreaInfoService;

    /**
     * 查询风险地区列表
     */
    @PreAuthorize("@ss.hasPermi('system:riskArea:list')")
    @GetMapping("/list")
    @ApiOperation("查询风险地区列表")
    public TableDataInfo list(RiskAreaInfo riskAreaInfo)
    {
//        startPage();
        List<RiskAreaInfo> list = riskAreaInfoService.selectRiskAreaInfoList(riskAreaInfo);
        return getDataTable(list);
    }

    /**
     * 导出风险地区列表
     */
    @PreAuthorize("@ss.hasPermi('system:riskArea:export')")
    @Log(title = "风险地区", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ApiOperation("导出风险地区列表")
    public void export(HttpServletResponse response, RiskAreaInfo riskAreaInfo)
    {
        List<RiskAreaInfo> list = riskAreaInfoService.selectRiskAreaInfoList(riskAreaInfo);
        ExcelUtil<RiskAreaInfo> util = new ExcelUtil<RiskAreaInfo>(RiskAreaInfo.class);
        util.exportExcel(response, list, "风险地区数据");
    }

    /**
     * 获取风险地区详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:riskArea:query')")
    @GetMapping(value = "/{riskareaid}")
    @ApiOperation("获取风险地区详细信息")
    public AjaxResult getInfo(@PathVariable("riskareaid") Long riskareaid)
    {
        return AjaxResult.success(riskAreaInfoService.selectRiskAreaInfoByRiskareaid(riskareaid));
    }

    /**
     * 新增风险地区
     */
    @PreAuthorize("@ss.hasPermi('system:riskArea:add')")
    @Log(title = "风险地区", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增风险地区")
    public AjaxResult add(@RequestBody RiskAreaInfo riskAreaInfo)
    {
        return toAjax(riskAreaInfoService.insertRiskAreaInfo(riskAreaInfo));
    }

    /**
     * 修改风险地区
     */
    @PreAuthorize("@ss.hasPermi('system:riskArea:edit')")
    @Log(title = "风险地区", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("修改风险地区")
    public AjaxResult edit(@RequestBody RiskAreaInfo riskAreaInfo)
    {
        return toAjax(riskAreaInfoService.updateRiskAreaInfo(riskAreaInfo));
    }

    /**
     * 删除风险地区
     */
    @PreAuthorize("@ss.hasPermi('system:riskArea:remove')")
    @Log(title = "风险地区", businessType = BusinessType.DELETE)
	@DeleteMapping("/{riskareaids}")
    @ApiOperation("删除风险地区")
    public AjaxResult remove(@PathVariable Long[] riskareaids)
    {
        return toAjax(riskAreaInfoService.deleteRiskAreaInfoByRiskareaids(riskareaids));
    }
}
