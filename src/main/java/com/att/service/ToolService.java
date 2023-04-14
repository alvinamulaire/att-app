package com.att.service;

import com.att.domain.tool.ToolRequest;
import com.att.domain.tool.ToolResponse;

public interface ToolService {

    /**
     * 夾具作業 - 資源和作業站資訊
     *
     * @param toolRequest
     * @return
     */
    ToolResponse getOpResInfo( ToolRequest toolRequest );

    /**
     * 夾具作業 - 刷SFC
     *
     * @param toolRequest
     * @return
     */
    ToolResponse scanSfc( ToolRequest toolRequest );

    /**
     * 夾具作業 - 刷工具&SN
     *
     * @param toolRequest
     * @return
     */
    ToolResponse scan( ToolRequest toolRequest );

    ToolResponse delTool( ToolRequest toolRequest );

    /**
     * 夾具作業 - 刷資源
     *
     * @param toolRequest
     * @return
     */
    ToolResponse scanResource( ToolRequest toolRequest );

    /**
     * 夾具作業 - 開始
     *
     * @param toolRequest
     */
    String start( ToolRequest toolRequest );

    /**
     * 夾具作業 - 完成
     *
     * @param toolRequest
     */
    String complete( ToolRequest toolRequest );

    /**
     * 夾具作業 - 下機
     *
     * @param toolRequest
     */
    String off( ToolRequest toolRequest );
}
