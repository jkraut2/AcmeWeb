package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;
/**
 * Decorator class for server status objects where operation status has been requested.
 */

public class OperationsDetailedServerStatus extends DetailedServerStatus{

    protected long id;
    protected String contentHeader;
    protected String statusDesc = "Unknown";

    public OperationsDetailedServerStatus(ServerStatus sStatus) {

        super(sStatus);
    }
    /**
     *
     * @return a string containing the server and operation status description
     */
    public String getStatusDesc(){
        return ServerManager.getCurrentServerStatus() +
                ServerManager.getCurrentOperations();
    }
}