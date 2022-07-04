package com.ruoyi.idfs.controller;

import java.util.List;

import com.ruoyi.system.domain.ScanInfo;
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
import com.ruoyi.system.domain.PositiveTravel;
import com.ruoyi.system.service.IPositiveTravelService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 阳性人员途径地址信息Controller
 *
 * @author SoLam
 * @date 2022-06-27
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
        //startPage();
        List<ScanInfo> list = positiveTravelService.selectPositiveScanListByRecordId(recordId);
        return getDataTable(list);
    }


    /**
     * 查询阳性人员途径地址信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:positiveTravel:list')")
    @GetMapping("/list")
    @ApiOperation("查询阳性人员途径地址信息列表")
    public TableDataInfo list(PositiveTravel positiveTravel)
    {
        //startPage();
        List<PositiveTravel> list = positiveTravelService.selectPositiveTravelList(positiveTravel);
        return getDataTable(list);
    }
    /**
     * 根据身份证号查询阳性人员途径地址信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:positiveTravel:list')")
    @GetMapping("/list/listByPeopleId/{peopleId}")
    @ApiOperation("查询阳性人员途径地址信息列表")
    public TableDataInfo listByPeopleId(@PathVariable("peopleId")String peopleId)
    {
        PositiveTravel positiveTravel = new PositiveTravel();
        positiveTravel.setPeopleId(peopleId);
        //startPage();
        List<PositiveTravel> list = positiveTravelService.selectPositiveTravelList(positiveTravel);
        return getDataTable(list);
    }

    /**
     * 导出阳性人员途径地址信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:positiveTravel:export')")
    @Log(title = "阳性人员途径地址信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ApiOperation("导出阳性人员途径地址信息列表")
    public void export(HttpServletResponse response, PositiveTravel positiveTravel)
    {
        List<PositiveTravel> list = positiveTravelService.selectPositiveTravelList(positiveTravel);
        ExcelUtil<PositiveTravel> util = new ExcelUtil<PositiveTravel>(PositiveTravel.class);
        util.exportExcel(response, list, "阳性人员途径地址信息数据");
    }

    /**
     * 获取阳性人员途径地址信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:positiveTravel:query')")
    @GetMapping(value = "/{travelId}")
    @ApiOperation("获取阳性人员途径地址信息详细信息")
    public AjaxResult getInfo(@PathVariable("travelId") Long travelId)
    {
        return AjaxResult.success(positiveTravelService.selectPositiveTravelByTravelId(travelId));
    }

    /**
     * 新增阳性人员途径地址信息
     */
    @PreAuthorize("@ss.hasPermi('system:positiveTravel:add')")
    @Log(title = "阳性人员途径地址信息", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增阳性人员途径地址信息")
    public AjaxResult add(@RequestBody PositiveTravel positiveTravel)
    {
        return toAjax(positiveTravelService.insertPositiveTravel(positiveTravel));
    }

    /**
     * 根据阳性人员途径地址信息更新密切接触者人员状态信息
     */
    @ApiOperation("根据阳性人员途径地址信息更新密切接触者人员状态信息")
    @PreAuthorize("@ss.hasPermi('idfs:positiveTravel:edit')")
    @Log(title = "人员表", businessType = BusinessType.UPDATE)
    @PutMapping("updateContact/{recordId}")
    public AjaxResult updateContactStatusByPositiveTravel(@PathVariable String recordId)
    {
        return toAjax(positiveTravelService.updateContactStatusByPositiveTravel(recordId));
    }

    /**
     * 修改阳性人员途径地址信息
     */
    @PreAuthorize("@ss.hasPermi('system:positiveTravel:edit')")
    @Log(title = "阳性人员途径地址信息", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("修改阳性人员途径地址信息")
    public AjaxResult edit(@RequestBody PositiveTravel positiveTravel)
    {
        return toAjax(positiveTravelService.updatePositiveTravel(positiveTravel));
    }

    /**
     * 删除阳性人员途径地址信息
     */
    @PreAuthorize("@ss.hasPermi('system:positiveTravel:remove')")
    @Log(title = "阳性人员途径地址信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{travelIds}")
    @ApiOperation("删除阳性人员途径地址信息")
    public AjaxResult remove(@PathVariable Long[] travelIds)
    {
        return toAjax(positiveTravelService.deletePositiveTravelByTravelIds(travelIds));
    }

}
