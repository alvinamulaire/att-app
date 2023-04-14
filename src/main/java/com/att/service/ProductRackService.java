package com.att.service;

import com.att.domain.productRack.ProductRackRequest;
import com.att.domain.productRack.ProductRackResponse;

import java.util.List;

public interface ProductRackService {

    /**
     * 料架作業-檢索
     *
     * @param productRackRequest
     * @return
     */
    ProductRackResponse productRetrieval( ProductRackRequest productRackRequest );

    /**
     * 料架作業-上架
     *
     * @param productRackRequest
     */
    void already( ProductRackRequest productRackRequest );

    /**
     * 料架作業-下架
     *
     * @param productRackRequest
     */
    void goOff( List<ProductRackRequest> productRackRequest );
}
