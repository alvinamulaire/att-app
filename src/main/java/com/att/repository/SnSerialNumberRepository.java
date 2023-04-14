package com.att.repository;

import com.att.repository.entity.ZSfcSnRelation;
import com.att.repository.entity.ZVwSfcSnRelation;

import java.util.List;

public interface SnSerialNumberRepository {

    List<ZSfcSnRelation> getSnRelation( ZSfcSnRelation zSfcSnRelation );

    void saveSn( ZSfcSnRelation zSfcSnRelation );

    List<ZVwSfcSnRelation> findZVwSfcSnRelation(ZVwSfcSnRelation zVwSfcSnRelation);
}
