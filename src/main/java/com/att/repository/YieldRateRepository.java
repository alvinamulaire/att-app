package com.att.repository;

import com.att.repository.entity.ZMaterialYieldBasis;
import com.att.repository.entity.ZVwMaterialYieldItemDesc;
import com.att.repository.entity.ZVwYieldBasisRouter;
import com.att.repository.entity.ZVwYieldRouter;

import java.util.List;

public interface YieldRateRepository {

    List<ZVwMaterialYieldItemDesc> getMaterialDesc( String site, String item, String locale );

    List<ZVwYieldBasisRouter> getYieldRouter( ZVwYieldBasisRouter zVwYieldBasisRouter );

    List<ZVwYieldRouter> getYieldInfo( String locale, ZVwYieldRouter zVwYieldRouter );

    List<ZMaterialYieldBasis> getMaterialYield( ZMaterialYieldBasis zMaterialYieldBasis );

    void deleteMaterialYield( String site, String item );

    void insertMaterialYield( ZMaterialYieldBasis zMaterialYieldBasis );
}
