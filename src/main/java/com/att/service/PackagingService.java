package com.att.service;

import com.att.domain.packaging.PackagingRequest;
import com.att.domain.packaging.PackagingResponse;
import com.att.repository.entity.ZPackMaster;
import com.fw.mes.me.domain.container.ContainerInfo;
import com.fw.mes.me.entity.ViewContainerPackingLevel;

import java.util.List;

public interface PackagingService {

    /**
     * 容器開窗
     *
     * @param containerInfo
     * @return
     */
    List<ViewContainerPackingLevel> getContainer( ContainerInfo containerInfo );

    /**
     * 產生箱號(棧板)
     *
     * @param packagingRequest
     * @return
     */
    ZPackMaster createNewNumber( PackagingRequest packagingRequest );

    /**
     * 包裝 - 檢索
     *
     * @param packagingRequest
     * @return
     */
    PackagingResponse retrieve( PackagingRequest packagingRequest );

    /**
     * 包裝 - 開箱 or 重量
     *
     * @param packagingRequest
     */
    void updateMaster( PackagingRequest packagingRequest );

    /**
     * 包裝 - 刷入SFC
     *
     * @param packagingRequest
     */
    PackagingResponse scanSfc( PackagingRequest packagingRequest );

    /**
     * 包裝 - 刷入SN
     *
     * @param packagingRequest
     * @return
     */
    PackagingResponse scanSn( PackagingRequest packagingRequest );

    /**
     * 包裝 - 刪除SN或箱號
     *
     * @param packagingRequest
     * @return
     */
    PackagingResponse deleteDetail( PackagingRequest packagingRequest );

    /**
     * 包裝 - 裝箱完成前檢查
     *
     * @param packagingRequest
     * @return
     */
    boolean preCompleteCarton( PackagingRequest packagingRequest );

    /**
     * 包裝 - 裝箱完成
     *
     * @param packagingRequest
     */
    void completeCarton( PackagingRequest packagingRequest );

    /**
     * 包裝 - 刷入箱號
     *
     * @param packagingRequest
     * @return
     */
    PackagingResponse scanCarton( PackagingRequest packagingRequest );

    /**
     * 包裝 - 棧板完成前檢查
     *
     * @param packagingRequest
     * @return
     */
    boolean preCompletePallet( PackagingRequest packagingRequest );

    /**
     * 包裝 - 棧板完成
     *
     * @param packagingRequest
     */
    void completePallet( PackagingRequest packagingRequest );

    ViewContainerPackingLevel getContainerInfo( ContainerInfo containerInfo );
}
