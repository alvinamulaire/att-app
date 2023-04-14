package com.att.controller;

import com.att.domain.print.RunCardRequest;
import com.att.domain.soRelease.ReleaseSfcResponse;
import com.att.domain.soRelease.SoCustom;
import com.att.domain.soRelease.SoInfo;
import com.att.service.ShopOrderReleaseService;
import com.sap.me.productdefinition.ItemBOHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin(origins = { "*" })
public class ShopOrderReleaseController {

    @Autowired
    private ShopOrderReleaseService shopOrderReleaseService;

    @PostMapping("so/retrieve")
    public SoCustom getReleaseSo( @RequestBody SoInfo soInfo ) {
        return shopOrderReleaseService.getReleaseSo(soInfo);
    }

    @PostMapping("so/release/list")
    public List<SoCustom> getSo( @RequestBody SoInfo soInfo ) {
        return shopOrderReleaseService.getSo(soInfo);
    }

    @PostMapping("so/release")
    public List<ReleaseSfcResponse> release( @RequestBody SoCustom soCustom ) throws ExecutionException, InterruptedException {
        boolean print = soCustom.isPrintRunCard();
        String site = soCustom.getSite();
        String user = soCustom.getUser();
        String item = soCustom.getPlannedItem();
        String itemVer = soCustom.getItemVer();

        List<ReleaseSfcResponse> responses = shopOrderReleaseService.release(soCustom);

        // 列印run card
        if (print) {
            RunCardRequest runCardRequest = new RunCardRequest();
            runCardRequest.setSite(site);
            runCardRequest.setUser(user);
            runCardRequest.setItemBo(new ItemBOHandle(site, item, itemVer).getValue());
            runCardRequest.setReleaseSfcResponses(responses);
            shopOrderReleaseService.printRunCard(runCardRequest);
        }

        return responses;
    }
}
