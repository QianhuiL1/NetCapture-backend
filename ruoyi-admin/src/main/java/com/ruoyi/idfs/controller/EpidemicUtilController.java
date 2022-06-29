package com.ruoyi.idfs.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.service.IEpidemicUtilService;
import com.ruoyi.system.service.ISojournInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/epidemicUtil")
@Api(tags = "疫情信息爬取控制")
public class EpidemicUtilController extends BaseController {

    @Autowired
    private IEpidemicUtilService epidemicUtilService;

    @Log(title = "手动更新疫情信息", businessType = BusinessType.UPDATE)
    @ApiOperation("手动更新疫情信息")
    @PostMapping("/manualUpdateEpidemicData")
    public AjaxResult manualUpdateEpidemicData()
    {
        return toAjax(epidemicUtilService.manualUpdateEpidemicData());
    }
}
