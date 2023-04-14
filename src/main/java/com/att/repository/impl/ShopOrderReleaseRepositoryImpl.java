package com.att.repository.impl;

import com.att.domain.shopOrder.SoCustomRequest;
import com.att.repository.ShopOrderReleaseRepository;
import com.att.repository.entity.ZVwBomComponent;
import com.att.repository.entity.ZVwBomComponentExample;
import com.att.repository.entity.ZVwSoCustom;
import com.att.repository.entity.ZVwSoCustomExample;
import com.att.repository.mapper.ZVwBomComponentMapper;
import com.att.repository.mapper.ZVwSoCustomMapper;
import com.fw.mes.me.entity.Router;
import com.fw.mes.me.entity.RouterExample;
import com.fw.mes.me.entity.Sfc;
import com.fw.mes.me.entity.SfcExample;
import com.fw.mes.me.mapper.RouterMapper;
import com.fw.mes.me.mapper.SfcMapper;
import com.fw.mes.util.FwUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopOrderReleaseRepositoryImpl implements ShopOrderReleaseRepository {

    @Autowired
    private ZVwSoCustomMapper zVwSoCustomMapper;

    @Autowired
    private ZVwBomComponentMapper zVwBomComponentMapper;

    @Autowired
    private SfcMapper sfcMapper;

    @Autowired
    private RouterMapper routerMapper;

    @Override
    public List<ZVwSoCustom> getSoReleaseDesc( String locale, SoCustomRequest zVwSoCustom ) {
        ZVwSoCustomExample example = new ZVwSoCustomExample();
        ZVwSoCustomExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(zVwSoCustom.getSite());

        if (!FwUtils.isNullOrEmpty(zVwSoCustom.getStatus())) {
            criteria.andStatusEqualTo(zVwSoCustom.getStatus());
        }

        if (!FwUtils.isNullOrEmpty(zVwSoCustom.getShopOrder())) {
            criteria.andShopOrderLike(zVwSoCustom.getShopOrder() + "%");
        }

        if(!FwUtils.isNullOrEmpty(zVwSoCustom.getAuart())){
            criteria.andAuartEqualTo(zVwSoCustom.getAuart());
        }

        if(!FwUtils.isNullOrEmpty(zVwSoCustom.getPlannedItem())){
            criteria.andPlannedItemEqualTo(zVwSoCustom.getPlannedItem());
        }

        if(!FwUtils.objIsEmpty(zVwSoCustom.getPlannedCompDateStart())){
            criteria.andPlannedCompDateGreaterThanOrEqualTo(zVwSoCustom.getPlannedCompDateStart());
        }

        if(!FwUtils.objIsEmpty(zVwSoCustom.getPlannedCompDateEnd())){
            criteria.andPlannedCompDateLessThanOrEqualTo(zVwSoCustom.getPlannedCompDateEnd());
        }

        example.setOrderByClause(" shop_order ");

        return zVwSoCustomMapper.selectByExample(locale, example);
    }

    @Override
    public List<ZVwBomComponent> getBomComponent( ZVwBomComponent zVwBomComponent ) {
        ZVwBomComponentExample example = new ZVwBomComponentExample();
        ZVwBomComponentExample.Criteria criteria = example.createCriteria();
        criteria.andSiteEqualTo(zVwBomComponent.getSite());

        if (!FwUtils.isNullOrEmpty(zVwBomComponent.getBom())) {
            criteria.andBomEqualTo(zVwBomComponent.getBom());
        }

        if (!FwUtils.isNullOrEmpty(zVwBomComponent.getRevision())) {
            criteria.andRevisionEqualTo(zVwBomComponent.getRevision());
        }

        return zVwBomComponentMapper.selectByExample(example);
    }

    @Override
    public Integer getLastSfcSerialNo( String site, String shopOrder ) {
        SfcExample sfcExample = new SfcExample();
        sfcExample.createCriteria()
                .andSiteEqualTo(site)
                .andSfcLike(shopOrder + "-__");
        sfcExample.setOrderByClause("sfc desc");

        List<Sfc> sfcList = sfcMapper.selectByExample(sfcExample);
        if (FwUtils.isEmpty(sfcList)) {
            return 0;
        } else {
            String sfc = sfcList.get(0).getSfc();
            return Integer.parseInt(sfc.substring(sfc.length() - 2));
        }
    }

    @Override
    public List<Router> getRouter( String site, String router, String ver ) {
        RouterExample example = new RouterExample();

        example.createCriteria()
                .andSiteEqualTo(site)
                .andRouterEqualTo(router)
                .andRevisionEqualTo(ver)
                .andCurrentRevisionEqualTo("true");

        return routerMapper.selectByExample(example);
    }
}
