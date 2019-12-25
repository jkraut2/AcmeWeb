

package com.acme.statusmgr.beans.complex;
import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.StatusInterface;
import com.acme.statusmgr.beans.complex.DetailedServerStatus;


/**
 * Decorator class for server status objects where operation status has been requested.
 */



public class OperationsDetailedServerStatus extends DetailedServerStatus {



    protected long id;
    protected String contentHeader;
    protected String statusDesc = "Unknown";


    public OperationsDetailedServerStatus(StatusInterface sStatus) {

        super(sStatus);
    }
    /**
     *
     * @return a string containing the server and operation status description
     */
    public String getStatusDesc(){

        return detailedServerStatus.getStatusDesc() + ",and" +
                detailedServerStatus.getServerManager().getCurrentOperations();
    }
}
