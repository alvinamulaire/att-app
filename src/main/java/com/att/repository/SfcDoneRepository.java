package com.att.repository;

import com.att.repository.entity.ZVwSfcDone;

import java.util.List;

public interface SfcDoneRepository {

	List<ZVwSfcDone> findSfcDoneInfo(ZVwSfcDone zSfcDone, String locale);
}
