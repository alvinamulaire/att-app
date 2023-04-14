package com.att.repository.mapper;

import com.att.repository.entity.ZVwYieldRouter;
import com.att.repository.entity.ZVwYieldRouterExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZVwYieldRouterMapper {
    long countByExample( ZVwYieldRouterExample example );

    List<ZVwYieldRouter> selectByExample( @Param("locale") String locale,
                                          @Param("example") ZVwYieldRouterExample example );
}