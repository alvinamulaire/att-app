package com.att.repository.mapper;

import com.att.repository.entity.ZVwQmsInspecJobResult;
import com.att.repository.entity.ZVwQmsInspecJobResultExample;
import java.util.List;

public interface ZVwQmsInspecJobResultMapper {
    long countByExample(ZVwQmsInspecJobResultExample example);

    List<ZVwQmsInspecJobResult> selectByExample(ZVwQmsInspecJobResultExample example);
}