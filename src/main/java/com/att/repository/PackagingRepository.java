package com.att.repository;

import com.att.domain.packaging.PackagingMaster;
import com.att.repository.entity.*;

import java.util.Date;
import java.util.List;

public interface PackagingRepository {

    void insertPackMaster( ZPackMaster zPackMaster );

    void updatePackMaster( ZPackMaster zPackMaster );

    void updatePackMasterStatus( List<String> sidList, String status );

    ZPackMaster getPackMaster( ZPackMaster zPackMaster );

    List<ZPackMaster> getPackMaster(String site, String containName, Date closeDateStart, Date closeDataEnd);

    List<ZPackMaster> getPackMaster( PackagingMaster packagingMaster );

    List<ZPackMaster> getPackMaster( String site, List<String> cartonList );

    List<ZPackDetail> getPackDetail( String masterSId );

    List<ZPackDetail> getPackDetail( List<String> masterSIdList );

    List<ZPackDetail> getPackDetail( ZPackDetail zPackDetail );

    List<ZVwInventoryAssyData> getBatchInv( ZVwInventoryAssyData inventory );

    void insertPackDetail( ZPackDetail zPackDetail );

    void deletePackDetail( ZPackDetail zPackDetail );

    void insertPackDetailLog( ZPackDetailLog zPackDetailLog );

    List<ZVwPackPallet> findPackPallet( String site, List<String> palletList, String locale );

    List<ZVwPackPallet> findPackPallet( ZVwPackPallet zVwPackPallet, String locale);

    List<ZVwPackCarton> findPackCarton( ZVwPackCarton zVwPackCarton, String locale );

    long cntPackDetail( String masterSid );
}
