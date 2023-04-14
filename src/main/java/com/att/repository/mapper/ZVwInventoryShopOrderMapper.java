package com.att.repository.mapper;

import com.att.repository.entity.ZVwInventoryShopOrder;
import com.att.repository.entity.ZVwInventoryShopOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZVwInventoryShopOrderMapper {
    long countByExample( ZVwInventoryShopOrderExample example );

    List<ZVwInventoryShopOrder> selectByExample( @Param("locale") String locale,
                                                 @Param("example") ZVwInventoryShopOrderExample example );
}