

package com.acme.statusmgr.beans.complex;
import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.StatusInterface;
import com.acme.statusmgr.beans.complex.DetailedServerStatus;


/**
 * Decorator class for server status objects where operation status has been requested.
 */



public class OperationsDetailedServerStatus extends DetailedServerStatus {


    public OperationsDetailedServerStatus(StatusInterface sStatus) {

        super(sStatus);
    }

    /**
     * Overrides the base server status's getStatusDesc to add
     * on to it the operations detail
     * @return a String representing the server status with operations detail
     */
    @Override
    public String generateStatusDesc() { return detailedServerStatus.generateStatusDesc() +
            ", and"+detailedServerStatus.getServerManager().getCurrentOperations();  }
}
