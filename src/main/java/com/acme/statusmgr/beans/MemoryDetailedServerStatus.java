
package com.acme.statusmgr.beans;
import com.acme.servermgr.ServerManager;

public class MemoryDetailedServerStatus implements StatusInterface {

    /**
     * Decorator class for server status objects where memory status has been requested.
     */
    protected long id;
    protected String contentHeader;
    protected String statusDesc = "Unknown";


    public MemoryDetailedServerStatus(StatusInterface sStatus) {

        super(sStatus);

    }

    /**
     *
     * @return a string containing the server and memory status description
     */
    public String getStatusDesc(){

        return ServerManager.getCurrentServerStatus() + ",and" +
                ServerManager.getCurrentMemory();
    }

}
