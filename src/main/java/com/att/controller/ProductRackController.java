package com.att.controller;

import com.att.domain.productRack.ProductRackRequest;
import com.att.domain.productRack.ProductRackResponse;
import com.att.service.ProductRackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = { "*" })
public class ProductRackController {

    @Autowired
    private ProductRackService productRackService;

    @PostMapping("production/rack/info")
    public ProductRackResponse productRetrieval( @RequestBody ProductRackRequest productRackRequest ) {
        return productRackService.productRetrieval(productRackRequest);
    }

    @PostMapping("production/rack/on")
    public void already( @RequestBody ProductRackRequest productRackRequest ) {
        productRackService.already(productRackRequest);
    }

    @PostMapping("production/rack/off")
    public void goOff( @RequestBody List<ProductRackRequest> productRackRequest ) {
        productRackService.goOff(productRackRequest);
    }
}
