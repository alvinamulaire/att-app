package com.att.mssql.repository;

import com.att.domain.iqc.IqcOutInfo;
import com.att.mssql.repository.entity.IqcInbound;
import com.att.mssql.repository.entity.IqcOutbound;
import com.att.repository.entity.ZSystemTransactionLog;
import com.att.repository.entity.ZVwQcPlanProd;
import com.att.repository.entity.ZVwQmsInspecJob;

import java.util.List;

public interface IqcRepository {

    List<IqcOutbound> getIqcOutBound( IqcOutInfo iqcOutInfo );

    void updateIqcOutBound( IqcOutbound iqcOutbound );

    List<ZVwQcPlanProd> getQcPlanProd( ZVwQcPlanProd zVwQcPlanProd );

    void insertTransactionLog( ZSystemTransactionLog zSystemTransactionLog );

    List<ZVwQmsInspecJob> getInspecJob( ZVwQmsInspecJob zVwQmsInspecJob );

    void insertIqcInBound( IqcInbound iqcInbound );
}
