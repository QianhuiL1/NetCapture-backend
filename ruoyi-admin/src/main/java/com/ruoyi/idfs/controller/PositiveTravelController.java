package com.ruoyi.idfs.controller;

import java.util.List;

import com.ruoyi.system.domain.ScanInfo;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletResponse;

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
import com.ruoyi.system.domain.PositiveTravel;
import com.ruoyi.system.service.IPositiveTravelService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 阳性人员途径地址信息Controller
 *
 * @author SoLam
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/positiveTravel")
@Api(tags = "阳性人员途径地址信息")
public class PositiveTravelController extends BaseController
{
    @Autowired
    private IPositiveTravelService positiveTravelService;


    /**
     * 根据某个record_id查询出所有密切接触者的人员信息
     */
    @ApiOperation("根据某个record_id查询出所有密切接触者的人员信息")
    @PreAuthorize("@ss.hasPermi('idfs:positiveTravel:list')")
    @GetMapping("/positiveScanList/{recordId}")
    public TableDataInfo positiveScanList(@PathVariable("recordId") String recordId)
    {
        startPage();
        List<ScanInfo> list = positiveTravelService.selectPositiveScanListByRecordId(recordId);
        return getDataTable(list);
    }


    /**
     * 查询阳性人员途径地址信息列表
     */
    @ApiOperation("查询阳性人员途径地址信息列表")
    @PreAuthorize("@ss.hasPermi('idfs:positiveTravel:list')")
    @GetMapping("/list")
    public TableDataInfo list(PositiveTravel positiveTravel)
    {
        startPage();
        List<PositiveTravel> list = positiveTravelService.selectPositiveTravelList(positiveTravel);
        return getDataTable(list);
    }

    /**
     * 导出阳性人员途径地址信息列表
     */
    @ApiOperation("导出阳性人员途径地址信息列表")
    @PreAuthorize("@ss.hasPermi('idfs:positiveTravel:export')")
    @Log(title = "阳性人员途径地址信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PositiveTravel positiveTravel)
    {
        List<PositiveTravel> list = positiveTravelService.selectPositiveTravelList(positiveTravel);
        ExcelUtil<PositiveTravel> util = new ExcelUtil<PositiveTravel>(PositiveTravel.class);
        util.exportExcel(response, list, "阳性人员途径地址信息数据");
    }

    /**
     * 获取阳性人员途径地址信息详细信息
     */
    @ApiOperation("获取阳性人员途径地址信息详细信息")
    @PreAuthorize("@ss.hasPermi('idfs:positiveTravel:query')")
    @GetMapping(value = "/{travelId}")
    public AjaxResult getInfo(@PathVariable("travelId") Long travelId)
    {
        return AjaxResult.success(positiveTravelService.selectPositiveTravelByTravelId(travelId));
    }

    /**
     * 新增阳性人员途径地址信息
     */
    @ApiOperation("新增阳性人员途径地址信息")
    @PreAuthorize("@ss.hasPermi('idfs:positiveTravel:add')")
    @Log(title = "阳性人员途径地址信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PositiveTravel positiveTravel)
    {
        return toAjax(positiveTravelService.insertPositiveTravel(positiveTravel));
    }

    /**
     * 修改阳性人员途径地址信息
     */
    @ApiOperation("修改阳性人员途径地址信息")
    @PreAuthorize("@ss.hasPermi('idfs:positiveTravel:edit')")
    @Log(title = "阳性人员途径地址信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PositiveTravel positiveTravel)
    {
        return toAjax(positiveTravelService.updatePositiveTravel(positiveTravel));
    }

    /**
     * 删除阳性人员途径地址信息
     */
    @ApiOperation("删除阳性人员途径地址信息")
    @PreAuthorize("@ss.hasPermi('idfs:positiveTravel:remove')")
    @Log(title = "阳性人员途径地址信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{travelIds}")
    public AjaxResult remove(@PathVariable Long[] travelIds)
    {
        return toAjax(positiveTravelService.deletePositiveTravelByTravelIds(travelIds));
    }

}
