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
import com.ruoyi.system.domain.EpidemicPredictionInfo;
import com.ruoyi.system.service.IEpidemicPredictionInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 疫情预测Controller
 *
 * @author SoLam
 * @date 2022-06-30
 */
@RestController
@RequestMapping("/epidemicPredic")
@Api(tags = "疫情预测")
public class EpidemicPredictionInfoController extends BaseController
{
    @Autowired
    private IEpidemicPredictionInfoService epidemicPredictionInfoService;

    /**
     * 查询疫情预测列表
     */
    @PreAuthorize("@ss.hasPermi('system:epidemicPredic:list')")
    @GetMapping("/list")
    @ApiOperation("查询疫情预测列表")
    public TableDataInfo list(EpidemicPredictionInfo epidemicPredictionInfo)
    {
        //startPage();
        List<EpidemicPredictionInfo> list = epidemicPredictionInfoService.selectEpidemicPredictionInfoList(epidemicPredictionInfo);
        return getDataTable(list);
    }

    /**
     * 导出疫情预测列表
     */
    @PreAuthorize("@ss.hasPermi('system:epidemicPredic:export')")
    @Log(title = "疫情预测", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ApiOperation("导出疫情预测列表")
    public void export(HttpServletResponse response, EpidemicPredictionInfo epidemicPredictionInfo)
    {
        List<EpidemicPredictionInfo> list = epidemicPredictionInfoService.selectEpidemicPredictionInfoList(epidemicPredictionInfo);
        ExcelUtil<EpidemicPredictionInfo> util = new ExcelUtil<EpidemicPredictionInfo>(EpidemicPredictionInfo.class);
        util.exportExcel(response, list, "疫情预测数据");
    }

    /**
     * 获取疫情预测详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:epidemicPredic:query')")
    @GetMapping(value = "/{id}")
    @ApiOperation("获取疫情预测详细信息")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(epidemicPredictionInfoService.selectEpidemicPredictionInfoById(id));
    }

    /**
     * 新增疫情预测
     */
    @PreAuthorize("@ss.hasPermi('system:epidemicPredic:add')")
    @Log(title = "疫情预测", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增疫情预测")
    public AjaxResult add(@RequestBody EpidemicPredictionInfo epidemicPredictionInfo)
    {
        return toAjax(epidemicPredictionInfoService.insertEpidemicPredictionInfo(epidemicPredictionInfo));
    }

    /**
     * 修改疫情预测
     */
    @PreAuthorize("@ss.hasPermi('system:epidemicPredic:edit')")
    @Log(title = "疫情预测", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("修改疫情预测")
    public AjaxResult edit(@RequestBody EpidemicPredictionInfo epidemicPredictionInfo)
    {
        return toAjax(epidemicPredictionInfoService.updateEpidemicPredictionInfo(epidemicPredictionInfo));
    }

    /**
     * 删除疫情预测
     */
    @PreAuthorize("@ss.hasPermi('system:epidemicPredic:remove')")
    @Log(title = "疫情预测", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    @ApiOperation("删除疫情预测")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(epidemicPredictionInfoService.deleteEpidemicPredictionInfoByIds(ids));
    }
}
