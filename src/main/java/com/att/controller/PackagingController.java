package com.att.controller;

import com.att.domain.packaging.PackagingRequest;
import com.att.domain.packaging.PackagingResponse;
import com.att.repository.entity.ZPackMaster;
import com.att.service.PackagingService;
import com.fw.mes.me.domain.container.ContainerInfo;
import com.fw.mes.me.entity.ViewContainerPackingLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = { "*" })
public class PackagingController {

    @Autowired
    private PackagingService packagingService;

    @PostMapping("packaging/container")
    public List<ViewContainerPackingLevel> getContainer( @RequestBody ContainerInfo containerInfo ) {
        return packagingService.getContainer(containerInfo);
    }

    @PostMapping("packaging/create/number")
    public ZPackMaster createNewNumber( @RequestBody PackagingRequest packagingRequest ) {
        return packagingService.createNewNumber(packagingRequest);
    }

    @PostMapping("packaging/retrieve")
    public PackagingResponse retrieve( @RequestBody PackagingRequest packagingRequest ) {
        return packagingService.retrieve(packagingRequest);
    }

    @PostMapping("packaging/upd/master")
    public void updateMaster( @RequestBody PackagingRequest packagingRequest ) {
        packagingService.updateMaster(packagingRequest);
    }

    @PostMapping("packaging/scan/sfc")
    public PackagingResponse scanSfc( @RequestBody PackagingRequest packagingRequest ) {
        return packagingService.scanSfc(packagingRequest);
    }

    @PostMapping("packaging/scan/sn")
    public PackagingResponse scanSn( @RequestBody PackagingRequest packagingRequest ) {
        return packagingService.scanSn(packagingRequest);
    }

    @PostMapping("packaging/del/detail")
    public PackagingResponse deleteDetail( @RequestBody PackagingRequest packagingRequest ) {
        return packagingService.deleteDetail(packagingRequest);
    }

    @PostMapping("packaging/pre/complete/carton")
    public boolean preCompleteCarton( @RequestBody PackagingRequest packagingRequest ) {
        return packagingService.preCompleteCarton(packagingRequest);
    }

    @PostMapping("packaging/complete/carton")
    public void completeCarton( @RequestBody PackagingRequest packagingRequest ) {
        packagingService.completeCarton(packagingRequest);
    }

    @PostMapping("packaging/scan/carton")
    public PackagingResponse scanCarton( @RequestBody PackagingRequest packagingRequest ) {
        return packagingService.scanCarton(packagingRequest);
    }

    @PostMapping("packaging/pre/complete/pallet")
    public boolean preCompletePallet( @RequestBody PackagingRequest packagingRequest ) {
        return packagingService.preCompletePallet(packagingRequest);
    }

    @PostMapping("packaging/complete/pallet")
    public void completePallet( @RequestBody PackagingRequest packagingRequest ) {
        packagingService.completePallet(packagingRequest);
    }

    @PostMapping("packaging/container/info")
    public ViewContainerPackingLevel getContainerInfo( @RequestBody ContainerInfo containerInfo ) {
        return packagingService.getContainerInfo(containerInfo);
    }
}
