package com.att.repository;

import com.att.domain.inpsec.InspecJobResultInfo;
import com.att.repository.entity.ZVwQmsInspecJob;
import com.att.repository.entity.ZVwQmsInspecJobResult;

import java.util.List;

public interface InspecRepository {

    List<ZVwQmsInspecJobResult> getInspecDetail( ZVwQmsInspecJobResult zVwQmsInspecJobResult );

    ZVwQmsInspecJob getInspecJob( String handle );

    List<ZVwQmsInspecJobResult> getInspecDetail( InspecJobResultInfo inspecJobResultInfo );
}
