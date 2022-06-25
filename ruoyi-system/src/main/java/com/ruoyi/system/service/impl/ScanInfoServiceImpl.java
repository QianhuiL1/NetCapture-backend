package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ScanInfoMapper;
import com.ruoyi.system.domain.ScanInfo;
import com.ruoyi.system.service.IScanInfoService;

/**
 * 扫码记录Service业务层处理
 * 
 * @author SoLam
 * @date 2022-06-25
 */
@Service
public class ScanInfoServiceImpl implements IScanInfoService 
{
    @Autowired
    private ScanInfoMapper scanInfoMapper;

    /**
     * 查询扫码记录
     * 
     * @param scanId 扫码记录主键
     * @return 扫码记录
     */
    @Override
    public ScanInfo selectScanInfoByScanId(Long scanId)
    {
        return scanInfoMapper.selectScanInfoByScanId(scanId);
    }

    /**
     * 查询扫码记录列表
     * 
     * @param scanInfo 扫码记录
     * @return 扫码记录
     */
    @Override
    public List<ScanInfo> selectScanInfoList(ScanInfo scanInfo)
    {
        return scanInfoMapper.selectScanInfoList(scanInfo);
    }

    /**
     * 新增扫码记录
     * 
     * @param scanInfo 扫码记录
     * @return 结果
     */
    @Override
    public int insertScanInfo(ScanInfo scanInfo)
    {
        return scanInfoMapper.insertScanInfo(scanInfo);
    }

    /**
     * 修改扫码记录
     * 
     * @param scanInfo 扫码记录
     * @return 结果
     */
    @Override
    public int updateScanInfo(ScanInfo scanInfo)
    {
        return scanInfoMapper.updateScanInfo(scanInfo);
    }

    /**
     * 批量删除扫码记录
     * 
     * @param scanIds 需要删除的扫码记录主键
     * @return 结果
     */
    @Override
    public int deleteScanInfoByScanIds(Long[] scanIds)
    {
        return scanInfoMapper.deleteScanInfoByScanIds(scanIds);
    }

    /**
     * 删除扫码记录信息
     * 
     * @param scanId 扫码记录主键
     * @return 结果
     */
    @Override
    public int deleteScanInfoByScanId(Long scanId)
    {
        return scanInfoMapper.deleteScanInfoByScanId(scanId);
    }
}
