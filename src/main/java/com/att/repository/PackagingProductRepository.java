package com.att.repository;

import com.att.repository.entity.*;

import java.util.List;

public interface PackagingProductRepository {

    List<ZVwQcPlanProd> getQcPlan( ZVwQcPlanProd zVwQcPlanProd );

    List<ZVwQcPlanItem> getQcPlanItem( ZVwQcPlanItem zVwQcPlanItem );

    List<ZPackInspecItem> getPackInspec( ZPackInspecItem zPackInspecItem );

    List<ZVwInspecItemDetail> getPackInspecDetail( ZVwInspecItemDetail zVwInspecItemDetail );

    List<ZVwPackInspecItemPlanDetail> getPackInspec( String site, String item );

    void insertPackInspecItem( ZPackInspecItem zPackInspecItem );

    void delPackInspecItem( String sid );

    void insertPackInspecItemLog( ZPackInspecItemLog zPackInspecItemLog );
}
