package com.ruoyi.idfs.controller;


import java.util.List;
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
import com.ruoyi.idfs.domain.PeopleTable;
import com.ruoyi.idfs.service.IPeopleTableService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;

/**
 * 存储普通人员的相关信息Controller
 *
 * @author ruoyi
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/system/table")
@Api(tags = "人员信息管理")
public class PeopleTableController extends BaseController
{
    @Autowired
    private IPeopleTableService peopleTableService;

    /**
     * 查询存储普通人员的相关信息列表
     */
    @ApiOperation("查询存储普通人员的相关信息列表")
    @PreAuthorize("@ss.hasPermi('system:table:list')")
    @GetMapping("/list")
    public TableDataInfo list(PeopleTable peopleTable)
    {
        startPage();
        List<PeopleTable> list = peopleTableService.selectPeopleTableList(peopleTable);
        return getDataTable(list);
    }

    /**
     * 导出存储普通人员的相关信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:table:export')")
    @Log(title = "存储普通人员的相关信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PeopleTable peopleTable)
    {
        List<PeopleTable> list = peopleTableService.selectPeopleTableList(peopleTable);
        ExcelUtil<PeopleTable> util = new ExcelUtil<PeopleTable>(PeopleTable.class);
        util.exportExcel(response, list, "存储普通人员的相关信息数据");
    }

    /**
     * 获取存储普通人员的相关信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:table:query')")
    @GetMapping(value = "/{peopleId}")
    public AjaxResult getInfo(@PathVariable("peopleId") String peopleId)
    {
        return AjaxResult.success(peopleTableService.selectPeopleTableByPeopleId(peopleId));
    }

    /**
     * 新增存储普通人员的相关信息
     */
    @PreAuthorize("@ss.hasPermi('system:table:add')")
    @Log(title = "存储普通人员的相关信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PeopleTable peopleTable)
    {
        return toAjax(peopleTableService.insertPeopleTable(peopleTable));
    }

    /**
     * 修改存储普通人员的相关信息
     */
    @PreAuthorize("@ss.hasPermi('system:table:edit')")
    @Log(title = "存储普通人员的相关信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PeopleTable peopleTable)
    {
        return toAjax(peopleTableService.updatePeopleTable(peopleTable));
    }

    /**
     * 删除存储普通人员的相关信息
     */
    @PreAuthorize("@ss.hasPermi('system:table:remove')")
    @Log(title = "存储普通人员的相关信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{peopleIds}")
    public AjaxResult remove(@PathVariable String[] peopleIds)
    {
        return toAjax(peopleTableService.deletePeopleTableByPeopleIds(peopleIds));
    }
}

