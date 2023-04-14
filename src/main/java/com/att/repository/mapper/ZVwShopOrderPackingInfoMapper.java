package com.att.repository.mapper;

import com.att.repository.entity.ZVwShopOrderPackingInfo;
import com.att.repository.entity.ZVwShopOrderPackingInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZVwShopOrderPackingInfoMapper {

    List<ZVwShopOrderPackingInfo> selectByExample( @Param("locale") String locale,
                                                   @Param("example") ZVwShopOrderPackingInfoExample example );
}