package com.att.repository;

import com.att.repository.entity.TdsResourceAbility;

public interface ResourceAbilityRepository {

    TdsResourceAbility getAbility( String site, String item, String operation, String resource );
}
