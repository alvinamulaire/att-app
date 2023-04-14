package com.att.repository.mapper;

import com.att.repository.entity.ZVwSfcNcData;
import com.att.repository.entity.ZVwSfcNcDataExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZVwSfcNcDataMapper {

    List<ZVwSfcNcData> selectByExample( @Param("locale") String locale,
                                        @Param("example") ZVwSfcNcDataExample example );
}