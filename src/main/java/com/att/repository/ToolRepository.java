package com.att.repository;

import com.att.domain.tool.ToolRequest;
import com.att.repository.entity.ZSnToolLog;
import com.att.repository.entity.ZSnToolState;

import java.util.List;

public interface ToolRepository {

    List<ZSnToolState> getToolList( ZSnToolState zSnToolState );

    void insertSnToolState( ZSnToolState zSnToolState );

    void updateSnToolState( ZSnToolState zSnToolState );

    void deleteSnToolState( String sid );

    void insertSnToolLog( ZSnToolLog zSnToolLog );

    void updateSnToolLog( ZSnToolLog zSnToolLog );

    List<ZSnToolState> getToolInfo( ToolRequest toolRequest );
}
