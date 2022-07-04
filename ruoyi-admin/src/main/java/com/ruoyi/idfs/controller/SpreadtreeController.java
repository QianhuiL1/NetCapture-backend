package com.ruoyi.idfs.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.Spreadtree;
import com.ruoyi.system.service.ISpreadtreeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 传播链条Controller
 *
 * @author Martin
 * @date 2022-07-04
 */
@RestController
@RequestMapping("/spreadtree")
public class SpreadtreeController extends BaseController
{
    @Autowired
    private ISpreadtreeService spreadtreeService;

    /**
     * 查询传播链条列表
     */
    @PreAuthorize("@ss.hasPermi('system:spreadtree:list')")
    @GetMapping("/list")
    public TableDataInfo list(Spreadtree spreadtree)
    {
        startPage();
        List<Spreadtree> list = spreadtreeService.selectSpreadtreeList(spreadtree);
        return getDataTable(list);
    }

    /**
     * 导出传播链条列表
     */
    @PreAuthorize("@ss.hasPermi('system:spreadtree:export')")
    @Log(title = "传播链条", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Spreadtree spreadtree)
    {
        List<Spreadtree> list = spreadtreeService.selectSpreadtreeList(spreadtree);
        ExcelUtil<Spreadtree> util = new ExcelUtil<Spreadtree>(Spreadtree.class);
        util.exportExcel(response, list, "传播链条数据");
    }

    /**
     * 获取传播链条详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:spreadtree:query')")
    @GetMapping(value = "/{spreadtreeId}")
    public AjaxResult getInfo(@PathVariable("spreadtreeId") Long spreadtreeId)
    {
        return AjaxResult.success(spreadtreeService.selectSpreadtreeBySpreadtreeId(spreadtreeId));
    }

    /**
     * 新增传播链条
     */
    @PreAuthorize("@ss.hasPermi('system:spreadtree:add')")
    @Log(title = "传播链条", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Spreadtree spreadtree)
    {
        return toAjax(spreadtreeService.insertSpreadtree(spreadtree));
    }

    /**
     * 修改传播链条
     */
    @PreAuthorize("@ss.hasPermi('system:spreadtree:edit')")
    @Log(title = "传播链条", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Spreadtree spreadtree)
    {
        return toAjax(spreadtreeService.updateSpreadtree(spreadtree));
    }

    /**
     * 删除传播链条
     */
    @PreAuthorize("@ss.hasPermi('system:spreadtree:remove')")
    @Log(title = "传播链条", businessType = BusinessType.DELETE)
    @DeleteMapping("/{spreadtreeIds}")
    public AjaxResult remove(@PathVariable Long[] spreadtreeIds)
    {
        return toAjax(spreadtreeService.deleteSpreadtreeBySpreadtreeIds(spreadtreeIds));
    }
}
