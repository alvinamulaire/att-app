package com.att.repository;

import com.att.repository.entity.ZMaterialShelfState;
import com.att.repository.entity.ZMaterialShelfStateLog;

import java.util.List;

public interface ProductRackRepository {

    List<ZMaterialShelfState> getShelf( ZMaterialShelfState zMaterialShelfState );

    void insertShelf( ZMaterialShelfState zMaterialShelfState );

    void deleteShelf( String sid );

    void insertShelfLog( ZMaterialShelfStateLog zMaterialShelfStateLog );
}
