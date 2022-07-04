package com.ruoyi.system.service.impl;

import com.ruoyi.system.service.IEpidemicUtilService;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.idfs.CrawlEpidemicDataUtil;

@Service
public class EpidemicUtilServiceImpl implements IEpidemicUtilService {

    @Override
    public void manageAutoUpdateEpidemicData() {

    }

    @Override
    public boolean manualUpdateEpidemicData() {
        return CrawlEpidemicDataUtil.crawlDataSavedIntoDB();
    }
}
