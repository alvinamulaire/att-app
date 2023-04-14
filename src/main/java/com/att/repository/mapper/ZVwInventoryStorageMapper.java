package com.att.repository.mapper;

import com.att.repository.entity.ZVwInventoryStorage;
import com.att.repository.entity.ZVwInventoryStorageExample;
import java.util.List;

public interface ZVwInventoryStorageMapper {
    long countByExample(ZVwInventoryStorageExample example);

    List<ZVwInventoryStorage> selectByExample(ZVwInventoryStorageExample example);
}