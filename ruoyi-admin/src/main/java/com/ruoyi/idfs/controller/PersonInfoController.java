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
import com.ruoyi.idfs.domain.PersonInfo;
import com.ruoyi.idfs.service.IPersonInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 存储普通人员的相关信息Controller
 * 
 * @author SoLam
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/idfs/personInfo")
public class PersonInfoController extends BaseController
{
    @Autowired
    private IPersonInfoService personInfoService;

    /**
     * 查询存储普通人员的相关信息列表
     */
    @PreAuthorize("@ss.hasPermi('idfs:personInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonInfo personInfo)
    {
        startPage();
        List<PersonInfo> list = personInfoService.selectPersonInfoList(personInfo);
        return getDataTable(list);
    }

    /**
     * 导出存储普通人员的相关信息列表
     */
    @PreAuthorize("@ss.hasPermi('idfs:personInfo:export')")
    @Log(title = "存储普通人员的相关信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonInfo personInfo)
    {
        List<PersonInfo> list = personInfoService.selectPersonInfoList(personInfo);
        ExcelUtil<PersonInfo> util = new ExcelUtil<PersonInfo>(PersonInfo.class);
        util.exportExcel(response, list, "存储普通人员的相关信息数据");
    }

    /**
     * 获取存储普通人员的相关信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('idfs:personInfo:query')")
    @GetMapping(value = "/{peopleId}")
    public AjaxResult getInfo(@PathVariable("peopleId") String peopleId)
    {
        return AjaxResult.success(personInfoService.selectPersonInfoByPeopleId(peopleId));
    }

    /**
     * 新增存储普通人员的相关信息
     */
    @PreAuthorize("@ss.hasPermi('idfs:personInfo:add')")
    @Log(title = "存储普通人员的相关信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonInfo personInfo)
    {
        return toAjax(personInfoService.insertPersonInfo(personInfo));
    }

    /**
     * 修改存储普通人员的相关信息
     */
    @PreAuthorize("@ss.hasPermi('idfs:personInfo:edit')")
    @Log(title = "存储普通人员的相关信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonInfo personInfo)
    {
        return toAjax(personInfoService.updatePersonInfo(personInfo));
    }

    /**
     * 删除存储普通人员的相关信息
     */
    @PreAuthorize("@ss.hasPermi('idfs:personInfo:remove')")
    @Log(title = "存储普通人员的相关信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{peopleIds}")
    public AjaxResult remove(@PathVariable String[] peopleIds)
    {
        return toAjax(personInfoService.deletePersonInfoByPeopleIds(peopleIds));
    }
}
