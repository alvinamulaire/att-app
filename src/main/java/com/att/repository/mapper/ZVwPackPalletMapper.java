package com.att.repository.mapper;

import com.att.repository.entity.ZVwPackPallet;
import com.att.repository.entity.ZVwPackPalletExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZVwPackPalletMapper {
    long countByExample(ZVwPackPalletExample example);

    int deleteByExample(ZVwPackPalletExample example);

    int insert(ZVwPackPallet record);

    int insertSelective(ZVwPackPallet record);

    List<ZVwPackPallet> selectByExample(@Param("example") ZVwPackPalletExample example, @Param("locale")String locale);

    int updateByExampleSelective(@Param("record") ZVwPackPallet record, @Param("example") ZVwPackPalletExample example);

    int updateByExample(@Param("record") ZVwPackPallet record, @Param("example") ZVwPackPalletExample example);
}