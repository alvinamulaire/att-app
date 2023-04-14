package com.att.service;

import com.att.domain.yield.YieldRateRequest;
import com.att.repository.entity.ZVwMaterialYieldItemDesc;
import com.att.repository.entity.ZVwYieldBasisRouter;
import com.att.repository.entity.ZVwYieldRouter;

import java.util.List;

public interface YieldRateService {

    /**
     * 良率維護-物料開窗
     *
     * @param site
     * @param item
     * @param locale
     * @return
     */
    List<ZVwMaterialYieldItemDesc> getMaterialDesc( String site, String item, String locale );

    /**
     * 良率維護-途程開窗
     *
     * @param site
     * @param item
     * @param router
     * @return
     */
    List<ZVwYieldBasisRouter> getYieldRouter( String site, String item, String router );

    /**
     * 良率維護-檢索
     *
     * @param yieldRateRequest
     * @return
     */
    List<ZVwYieldRouter> getMaterialYield( YieldRateRequest yieldRateRequest );

    /**
     * 良率維護-匯入
     *
     * @param yieldRateRequest
     */
    void importYield( YieldRateRequest yieldRateRequest );
}
