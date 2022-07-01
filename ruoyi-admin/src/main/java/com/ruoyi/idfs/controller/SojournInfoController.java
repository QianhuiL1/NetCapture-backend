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
import com.ruoyi.system.domain.SojournInfo;
import com.ruoyi.system.service.ISojournInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 旅居信息登记表Controller
 *
 * @author ruoyi
 * @date 2022-06-27
 */
@Api(tags="旅居信息登记表")
@RestController
@RequestMapping("/system/sojourn_table")
public class SojournInfoController extends BaseController
{
    @Autowired
    private ISojournInfoService sojournInfoService;

    /**
     * 查询旅居信息登记表列表
     */
    @ApiOperation("查询旅居信息登记表列表")
    @PreAuthorize("@ss.hasPermi('system:sojourn_table:list')")
    @GetMapping("/list")
    public TableDataInfo list(SojournInfo sojournInfo)
    {
        //startPage();
        List<SojournInfo> list = sojournInfoService.selectSojournInfoList(sojournInfo);
        return getDataTable(list);
    }

    /**
     * 根据身份证号查询旅居信息登记表列表
     */
    @ApiOperation("根据身份证号查询旅居信息登记表列表")
    @PreAuthorize("@ss.hasPermi('system:sojourn_table:list')")
    @GetMapping("/listByPeopleId/{peopleId}")
    public TableDataInfo listByPeopleId(@PathVariable("peopleId") String peopleId)
    {
        //startPage();
        List<SojournInfo> list = sojournInfoService.selectSojournInfoListByPeopleId(peopleId);
        return getDataTable(list);
    }

    /**
     * 导出旅居信息登记表列表
     */
    @ApiOperation("导出旅居信息登记表列表")
    @PreAuthorize("@ss.hasPermi('system:sojourn_table:export')")
    @Log(title = "旅居信息登记表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SojournInfo sojournInfo)
    {
        List<SojournInfo> list = sojournInfoService.selectSojournInfoList(sojournInfo);
        ExcelUtil<SojournInfo> util = new ExcelUtil<SojournInfo>(SojournInfo.class);
        util.exportExcel(response, list, "旅居信息登记表数据");
    }

    /**
     * 获取旅居信息登记表详细信息
     */
    @ApiOperation("获取旅居信息登记表详细信息")
    @PreAuthorize("@ss.hasPermi('system:sojourn_table:query')")
    @GetMapping(value = "/{sourjornId}")
    public AjaxResult getInfo(@PathVariable("sourjornId") Long sourjornId)
    {
        return AjaxResult.success(sojournInfoService.selectSojournInfoBySourjornId(sourjornId));
    }

    /**
     * 新增旅居信息登记表
     */
    @ApiOperation("新增旅居信息登记表")
    @PreAuthorize("@ss.hasPermi('system:sojourn_table:add')")
    @Log(title = "旅居信息登记表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SojournInfo sojournInfo)
    {
        return toAjax(sojournInfoService.insertSojournInfo(sojournInfo));
    }

    /**
     * 修改旅居信息登记表
     */
    @ApiOperation("修改旅居信息登记表")
    @PreAuthorize("@ss.hasPermi('system:sojourn_table:edit')")
    @Log(title = "旅居信息登记表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SojournInfo sojournInfo)
    {
        return toAjax(sojournInfoService.updateSojournInfo(sojournInfo));
    }

    /**
     * 删除旅居信息登记表
     */
    @ApiOperation("删除旅居信息登记表")
    @PreAuthorize("@ss.hasPermi('system:sojourn_table:remove')")
    @Log(title = "旅居信息登记表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{sourjornIds}")
    public AjaxResult remove(@PathVariable Long[] sourjornIds)
    {
        return toAjax(sojournInfoService.deleteSojournInfoBySourjornIds(sourjornIds));
    }
}
