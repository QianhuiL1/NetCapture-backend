package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ScanInfo;
import com.ruoyi.system.domain.vo.ScanFormVo;

/**
 * 扫码记录Service接口
 *
 * @author SoLam
 * @date 2022-06-25
 */
public interface IScanInfoService
{
    /**
     * 查询扫码记录
     *
     * @param scanId 扫码记录主键
     * @return 扫码记录
     */
    public ScanInfo selectScanInfoByScanId(Long scanId);

    /**
     * 查询扫码记录列表
     *
     * @param scanInfo 扫码记录
     * @return 扫码记录集合
     */
    public List<ScanInfo> selectScanInfoList(ScanInfo scanInfo);

    /**
     * 新增扫码记录
     *
     * @param scanInfo 扫码记录
     * @return 结果
     */
    public int insertScanInfo(ScanInfo scanInfo);

    /**
     * 修改扫码记录
     *
     * @param scanInfo 扫码记录
     * @return 结果
     */
    public int updateScanInfo(ScanInfo scanInfo);

    /**
     * 批量删除扫码记录
     *
     * @param scanIds 需要删除的扫码记录主键集合
     * @return 结果
     */
    public int deleteScanInfoByScanIds(Long[] scanIds);

    /**
     * 删除扫码记录信息
     *
     * @param scanId 扫码记录主键
     * @return 结果
     */
    public int deleteScanInfoByScanId(Long scanId);

    public int saveScanInfo(ScanFormVo scanForm);


}
