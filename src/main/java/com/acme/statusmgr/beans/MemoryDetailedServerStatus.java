package com.acme.statusmgr.beans;
import com.acme.servermgr.ServerManager;

public class MemoryDetailedServerStatus extends DetailedServerStatus {
    /**
     * Decorator class for server status objects where memory status has been requested.
     */
    protected long id;
    protected String contentHeader;
    protected String statusDesc = "Unknown";

    public MemoryDetailedServerStatus(ServerStatus sStatus) {

       super(sStatus);

    }

    /**
     *
     * @return a string containing the server and memory status description
     */
    public String getStatusDesc(){
        return ServerManager.getCurrentServerStatus() +
                ServerManager.getCurrentMemory();
    }

}
