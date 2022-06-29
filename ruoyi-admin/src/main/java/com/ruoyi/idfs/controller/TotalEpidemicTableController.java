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
import com.ruoyi.system.domain.TotalEpidemicTable;
import com.ruoyi.system.service.ITotalEpidemicTableService;
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
public class TotalEpidemicTableController extends BaseController
{
    @Autowired
    private ITotalEpidemicTableService totalEpidemicTableService;

    /**
     * 查询整体疫情列表
     */
    @PreAuthorize("@ss.hasPermi('system:totalEpidemic:list')")
    @GetMapping("/list")
    @ApiOperation("查询整体疫情列表")
    public TableDataInfo list(TotalEpidemicTable totalEpidemicTable)
    {
        startPage();
        List<TotalEpidemicTable> list = totalEpidemicTableService.selectTotalEpidemicTableList(totalEpidemicTable);
        return getDataTable(list);
    }

    /**
     * 导出整体疫情列表
     */
    @PreAuthorize("@ss.hasPermi('system:totalEpidemic:export')")
    @Log(title = "整体疫情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ApiOperation("导出整体疫情列表")
    public void export(HttpServletResponse response, TotalEpidemicTable totalEpidemicTable)
    {
        List<TotalEpidemicTable> list = totalEpidemicTableService.selectTotalEpidemicTableList(totalEpidemicTable);
        ExcelUtil<TotalEpidemicTable> util = new ExcelUtil<TotalEpidemicTable>(TotalEpidemicTable.class);
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
        return AjaxResult.success(totalEpidemicTableService.selectTotalEpidemicTableByTotalepidemicid(totalepidemicid));
    }

    /**
     * 新增整体疫情
     */
    @PreAuthorize("@ss.hasPermi('system:totalEpidemic:add')")
    @Log(title = "整体疫情", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增整体疫情")
    public AjaxResult add(@RequestBody TotalEpidemicTable totalEpidemicTable)
    {
        return toAjax(totalEpidemicTableService.insertTotalEpidemicTable(totalEpidemicTable));
    }

    /**
     * 修改整体疫情
     */
    @PreAuthorize("@ss.hasPermi('system:totalEpidemic:edit')")
    @Log(title = "整体疫情", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("修改整体疫情")
    public AjaxResult edit(@RequestBody TotalEpidemicTable totalEpidemicTable)
    {
        return toAjax(totalEpidemicTableService.updateTotalEpidemicTable(totalEpidemicTable));
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
        return toAjax(totalEpidemicTableService.deleteTotalEpidemicTableByTotalepidemicids(totalepidemicids));
    }
}
