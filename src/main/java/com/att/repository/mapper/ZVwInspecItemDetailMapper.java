package com.att.repository.mapper;

import com.att.repository.entity.ZVwInspecItemDetail;
import com.att.repository.entity.ZVwInspecItemDetailExample;
import java.util.List;

public interface ZVwInspecItemDetailMapper {
    long countByExample(ZVwInspecItemDetailExample example);

    List<ZVwInspecItemDetail> selectByExample(ZVwInspecItemDetailExample example);
}