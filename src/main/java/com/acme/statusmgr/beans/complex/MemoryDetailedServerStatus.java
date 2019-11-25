

package com.acme.statusmgr.beans.complex;
import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.StatusInterface;
import com.acme.statusmgr.beans.complex.DetailedServerStatus;

public class MemoryDetailedServerStatus extends DetailedServerStatus {

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

        return detailedServerStatus.getStatusDesc() + ",and" +
                ServerManager.getCurrentMemory();
    }

}
