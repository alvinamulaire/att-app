package com.att.repository.impl;

import com.att.domain.packaging.PackagingMaster;
import com.att.repository.PackagingRepository;
import com.att.repository.entity.*;
import com.att.repository.mapper.*;
import com.fw.mes.util.FwUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class PackagingRepositoryImpl implements PackagingRepository {

    @Autowired
    private ZPackMasterMapper zPackMasterMapper;

    @Autowired
    private ZPackDetailMapper zPackDetailMapper;

    @Autowired
    private ZVwInventoryAssyDataMapper zVwInventoryAssyDataMapper;

    @Autowired
    private ZPackDetailLogMapper zPackDetailLogMapper;

    @Autowired
    private ZVwPackPalletMapper zVwPackPalletMapper;

    @Autowired
    private ZVwPackCartonMapper zVwPackCartonMapper;

    @Override
    public void insertPackMaster( ZPackMaster zPackMaster ) {
        zPackMasterMapper.insertSelective(zPackMaster);
    }

    @Override
    public void updatePackMaster( ZPackMaster zPackMaster ) {
        ZPackMasterExample example = new ZPackMasterExample();
        ZPackMasterExample.Criteria criteria = example.createCriteria();
        criteria.andSidEqualTo(zPackMaster.getSid());

        zPackMasterMapper.updateByExampleSelective(zPackMaster, example);
    }

    @Override
    public void updatePackMasterStatus( List<String> sidList, String status ) {
        ZPackMasterExample example = new ZPackMasterExample();
        example.createCriteria().andSidIn(sidList);
        ZPackMaster zPackMaster = new ZPackMaster();
        zPackMaster.setStatus(status);
        zPackMasterMapper.updateByExampleSelective(zPackMaster, example);
    }

    @Override
    public ZPackMaster getPackMaster( ZPackMaster zPackMaster ) {
        ZPackMasterExample example = new ZPackMasterExample();
        ZPackMasterExample.Criteria criteria = example.createCriteria();
        criteria.andSiteEqualTo(zPackMaster.getSite());

        if (!FwUtils.isNullOrEmpty(zPackMaster.getSid())) {
            criteria.andSidEqualTo(zPackMaster.getSid());
        }

        if (!FwUtils.isNullOrEmpty(zPackMaster.getContainerNo())) {
            criteria.andContainerNoEqualTo(zPackMaster.getContainerNo());
        }

        if (!FwUtils.isNullOrEmpty(zPackMaster.getContainerType())) {
            criteria.andContainerTypeEqualTo(zPackMaster.getContainerType());
        }

        List<ZPackMaster> list = zPackMasterMapper.selectByExample(example);

        return FwUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    public List<ZPackMaster> getPackMaster( String site, String containName, Date closeDateStart, Date closeDataEnd ) {
        ZPackMasterExample example = new ZPackMasterExample();
        ZPackMasterExample.Criteria criteria = example.createCriteria();
        criteria.andSiteEqualTo(site);
        if (!FwUtils.isNullOrEmpty(containName)) {
            criteria.andContainerNameEqualTo(containName);
        }
        if (!FwUtils.objIsEmpty(closeDateStart) && !FwUtils.objIsEmpty(closeDataEnd)) {
            criteria.andCloseDateTimeBetween(closeDateStart, closeDataEnd);
        }
        example.setOrderByClause(" CONTAINER_NO ");
        return zPackMasterMapper.selectByExample(example);
    }

    @Override
    public List<ZPackMaster> getPackMaster( String site, List<String> cartonList ) {
        ZPackMasterExample example = new ZPackMasterExample();
        example.createCriteria()
                .andSiteEqualTo(site)
                .andContainerTypeEqualTo("C")
                .andContainerNoIn(cartonList);
        return zPackMasterMapper.selectByExample(example);
    }

    @Override
    public List<ZPackMaster> getPackMaster( PackagingMaster packagingMaster ) {
        ZPackMasterExample example = new ZPackMasterExample();
        ZPackMasterExample.Criteria criteria = example.createCriteria();
        criteria.andSiteEqualTo(packagingMaster.getSite());

        if (!FwUtils.isNullOrEmpty(packagingMaster.getContainerNo())) {
            criteria.andContainerNoEqualTo(packagingMaster.getContainerNo());
        }

        if (!FwUtils.isEmpty(packagingMaster.getCartonList())) {
            criteria.andContainerNoIn(packagingMaster.getCartonList());
        }

        return zPackMasterMapper.selectByExample(example);
    }

    @Override
    public List<ZPackDetail> getPackDetail( String masterSId ) {
        ZPackDetailExample example = new ZPackDetailExample();
        ZPackDetailExample.Criteria criteria = example.createCriteria();
        criteria.andMasterSidEqualTo(masterSId);

        example.setOrderByClause(" CREATED_DATE_TIME ");
        return zPackDetailMapper.selectByExample(example);
    }

    @Override
    public List<ZPackDetail> getPackDetail( List<String> masterSIdList ) {
        ZPackDetailExample example = new ZPackDetailExample();
        ZPackDetailExample.Criteria criteria = example.createCriteria();
        criteria.andMasterSidIn(masterSIdList);

        return zPackDetailMapper.selectByExample(example);
    }

    @Override
    public List<ZPackDetail> getPackDetail( ZPackDetail zPackDetail ) {
        ZPackDetailExample example = new ZPackDetailExample();
        ZPackDetailExample.Criteria criteria = example.createCriteria();
        criteria.andSiteEqualTo(zPackDetail.getSite());

        if (!FwUtils.isNullOrEmpty(zPackDetail.getMasterSid())) {
            criteria.andMasterSidEqualTo(zPackDetail.getMasterSid());
        }

        if (!FwUtils.isNullOrEmpty(zPackDetail.getSfc())) {
            criteria.andSfcEqualTo(zPackDetail.getSfc());
        }

        if (!FwUtils.isNullOrEmpty(zPackDetail.getSn())) {
            criteria.andSnEqualTo(zPackDetail.getSn());
        }

        if (!FwUtils.isNullOrEmpty(zPackDetail.getCartonNo())) {
            criteria.andCartonNoEqualTo(zPackDetail.getCartonNo());
        }

        return zPackDetailMapper.selectByExample(example);
    }

    @Override
    public List<ZVwInventoryAssyData> getBatchInv( ZVwInventoryAssyData inventory ) {
        ZVwInventoryAssyDataExample example = new ZVwInventoryAssyDataExample();
        ZVwInventoryAssyDataExample.Criteria criteria = example.createCriteria();
        criteria.andSiteEqualTo(inventory.getSite())
                .andResourceLocBoEqualTo(inventory.getResourceLocBo())
                .andResourceLocResEqualTo("true")
                .andDataFieldEqualTo("BATCH_NUMBER")
                .andDataAttrEqualTo(inventory.getDataAttr());

        return zVwInventoryAssyDataMapper.selectByExample(example);
    }

    @Override
    public void insertPackDetail( ZPackDetail zPackDetail ) {
        zPackDetailMapper.insertSelective(zPackDetail);
    }

    @Override
    public void deletePackDetail( ZPackDetail zPackDetail ) {
        ZPackDetailExample example = new ZPackDetailExample();
        ZPackDetailExample.Criteria criteria = example.createCriteria();
        criteria.andMasterSidEqualTo(zPackDetail.getMasterSid());

        if (!FwUtils.isNullOrEmpty(zPackDetail.getSfc())) {
            criteria.andSfcEqualTo(zPackDetail.getSfc());
        }

        if (!FwUtils.isNullOrEmpty(zPackDetail.getSn())) {
            criteria.andSnEqualTo(zPackDetail.getSn());
        }

        if (!FwUtils.isNullOrEmpty(zPackDetail.getCartonNo())) {
            criteria.andCartonNoEqualTo(zPackDetail.getCartonNo());
        }

        zPackDetailMapper.deleteByExample(example);
    }

    @Override
    public void insertPackDetailLog( ZPackDetailLog zPackDetailLog ) {
        zPackDetailLogMapper.insertSelective(zPackDetailLog);
    }

    @Override
    public List<ZVwPackPallet> findPackPallet( String site, List<String> palletList, String locale ) {
        ZVwPackPalletExample example = new ZVwPackPalletExample();
        example.createCriteria()
                .andSiteEqualTo(site)
                .andMasterContainerNoIn(palletList);
        return zVwPackPalletMapper.selectByExample(example, locale);
    }

    @Override
    public List<ZVwPackPallet> findPackPallet( ZVwPackPallet zVwPackPallet, String locale ) {
        ZVwPackPalletExample example = new ZVwPackPalletExample();
        ZVwPackPalletExample.Criteria criteria = example.createCriteria();
        example.createCriteria().andSiteEqualTo(zVwPackPallet.getSite());
        if (!FwUtils.isNullOrEmpty(zVwPackPallet.getMasterContainerNo())) {
            criteria.andMasterContainerNoEqualTo(zVwPackPallet.getMasterContainerNo());
        }
        if (!FwUtils.isNullOrEmpty(zVwPackPallet.getShopOrder())) {
            criteria.andShopOrderEqualTo(zVwPackPallet.getShopOrder());
        }
        if (!FwUtils.isNullOrEmpty(zVwPackPallet.getSfc())) {
            criteria.andSfcEqualTo(zVwPackPallet.getSfc());
        }
        return zVwPackPalletMapper.selectByExample(example, locale);
    }

    @Override
    public List<ZVwPackCarton> findPackCarton( ZVwPackCarton zVwPackCarton, String locale ) {
        ZVwPackCartonExample example = new ZVwPackCartonExample();
        ZVwPackCartonExample.Criteria criteria = example.createCriteria();
        criteria.andSiteEqualTo(zVwPackCarton.getSite());
        if (!FwUtils.isNullOrEmpty(zVwPackCarton.getCartonContainerNo())) {
            criteria.andCartonContainerNoEqualTo(zVwPackCarton.getCartonContainerNo());
        }
        if (!FwUtils.isNullOrEmpty(zVwPackCarton.getPalletContainerNo())) {
            criteria.andPalletContainerNoEqualTo(zVwPackCarton.getPalletContainerNo());
        }
        if (!FwUtils.isNullOrEmpty(zVwPackCarton.getSfc())) {
            criteria.andSfcEqualTo(zVwPackCarton.getSfc());
        }
        if (!FwUtils.isNullOrEmpty(zVwPackCarton.getShopOrder())) {
            criteria.andShopOrderEqualTo(zVwPackCarton.getShopOrder());
        }

        return zVwPackCartonMapper.selectByExample(example, locale);
    }

    @Override
    public long cntPackDetail( String masterSid ) {
        ZPackDetailExample example = new ZPackDetailExample();
        ZPackDetailExample.Criteria criteria = example.createCriteria();
        criteria.andMasterSidEqualTo(masterSid);
        return zPackDetailMapper.countByExample(example);
    }


}
