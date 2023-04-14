package com.att.repository.mapper;

import com.att.repository.entity.ZVwQmsInspecJob;
import com.att.repository.entity.ZVwQmsInspecJobExample;
import java.util.List;

public interface ZVwQmsInspecJobMapper {
    long countByExample(ZVwQmsInspecJobExample example);

    List<ZVwQmsInspecJob> selectByExampleWithBLOBs(ZVwQmsInspecJobExample example);

    List<ZVwQmsInspecJob> selectByExample(ZVwQmsInspecJobExample example);
}