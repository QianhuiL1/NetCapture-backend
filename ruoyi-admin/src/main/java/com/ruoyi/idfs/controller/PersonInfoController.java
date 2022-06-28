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
import com.ruoyi.system.domain.PersonInfo;
import com.ruoyi.system.service.IPersonInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 存储普通人员的相关信息Controller
 *
 * @author SoLam
 * @date 2022-06-25
 */
@RestController
@RequestMapping("/personInfo")
@Api(tags = "存储普通人员的相关信息")
public class PersonInfoController extends BaseController
{
    @Autowired
    private IPersonInfoService personInfoService;



    /**
     * 查询存储普通人员的相关信息列表
     */
    @ApiOperation("查询存储普通人员的相关信息列表")
    @PreAuthorize("@ss.hasPermi('idfs:personInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonInfo personInfo)
    {
        startPage();
        List<PersonInfo> list = personInfoService.selectPersonInfoList(personInfo);
        return getDataTable(list);
    }
    @ApiOperation("根据地址查询存储普通人员的相关信息列表")
    @PreAuthorize("@ss.hasPermi('idfs:personInfo:list')")
    @GetMapping("/listByAddress/{address}")
    public TableDataInfo listByAddress(@PathVariable("address") String address)
    {
        startPage();
        PersonInfo personInfo = new PersonInfo();
        personInfo.setAddress(address);
        List<PersonInfo> list = personInfoService.selectPersonInfoList(personInfo);
        return getDataTable(list);
    }
    @ApiOperation("根据姓名查询存储普通人员的相关信息列表")
    @PreAuthorize("@ss.hasPermi('idfs:personInfo:list')")
    @GetMapping("/listByName/{name}")
    public TableDataInfo listByName(@PathVariable("name") String name)
    {
        startPage();
        PersonInfo personInfo = new PersonInfo();
        personInfo.setName(name);
        List<PersonInfo> list = personInfoService.selectPersonInfoList(personInfo);
        return getDataTable(list);
    }
    @ApiOperation("根据区号查询存储普通人员的相关信息列表")
    @PreAuthorize("@ss.hasPermi('idfs:personInfo:list')")
    @GetMapping("/listByAncestors/{ancestors}")
    public TableDataInfo listByAncestors(@PathVariable("ancestors") String ancestors)
    {
        startPage();
        PersonInfo personInfo = new PersonInfo();
        personInfo.setAncestors(ancestors);
        List<PersonInfo> list = personInfoService.selectPersonInfoList(personInfo);
        return getDataTable(list);
    }
    /**
     * 导出存储普通人员的相关信息列表
     */
    @ApiOperation("导出存储普通人员的相关信息列表")
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
    @ApiOperation("获取存储普通人员的相关信息详细信息")
    @PreAuthorize("@ss.hasPermi('idfs:personInfo:query')")
    @GetMapping(value = "/{peopleId}")
    public AjaxResult getInfo(@PathVariable("peopleId") String peopleId)
    {
        return AjaxResult.success(personInfoService.selectPersonInfoByPeopleId(peopleId));
    }

    /**
     * 获取某一状态的相关人员信息列表
     */
    @ApiOperation("获取某一状态的相关人员信息列表")
    @PreAuthorize("@ss.hasPermi('idfs:personInfo:statuslist')")
    @GetMapping(value = "/statuslist/{status}")
    public TableDataInfo statuslist(@PathVariable("status") String status)
    {
        startPage();
        return getDataTable(personInfoService.selectPersonInfoListByStatus(status));
    }

    /**
     * 新增存储普通人员的相关信息
     */
    @ApiOperation("新增存储普通人员的相关信息")
    @PreAuthorize("@ss.hasPermi('idfs:personInfo:add')")
    @Log(title = "存储普通人员的相关信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonInfo personInfo)
    {
        return toAjax(personInfoService.insertPersonInfo(personInfo));
    }



    /**
     * 根据密接人员家庭地址修改次密接人员健康状态
     */
    @ApiOperation(value = "根据密切接触者人员家庭住址信息更新次密切接触者人员状态信息")
    @PreAuthorize("@ss.hasPermi('idfs:positiveTravel:edit')")
    @Log(title = "人员表", businessType = BusinessType.UPDATE)
    @PutMapping("updateSecondContact/{address}")
    public AjaxResult updateSecondContactStatusByContact(@PathVariable String address)
    {
        return toAjax(personInfoService.updateSecondContactStatusByContact(address));
    }

    /**
     * 修改存储普通人员的相关信息
     */
    @ApiOperation("修改存储普通人员的相关信息")
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
    @ApiOperation("删除存储普通人员的相关信息")
    @PreAuthorize("@ss.hasPermi('idfs:personInfo:remove')")
    @Log(title = "存储普通人员的相关信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{peopleIds}")
    public AjaxResult remove(@PathVariable String[] peopleIds)
    {
        return toAjax(personInfoService.deletePersonInfoByPeopleIds(peopleIds));
    }
}
