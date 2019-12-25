

package com.acme.statusmgr.beans.complex;
import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.StatusInterface;
import com.acme.statusmgr.beans.complex.DetailedServerStatus;

/**
 * Decorator class for server status objects where memory status has been requested.
 */

public class MemoryDetailedServerStatus extends DetailedServerStatus {

    public MemoryDetailedServerStatus(StatusInterface sStatus) {

        super(sStatus);

    }

    /**
     * Overrides the base server status's getStatusDesc to add
     * on to it the memory detail
     * @return a String representing the server status with memory detail
     */
    @Override
    public String generateStatusDesc() { return detailedServerStatus.generateStatusDesc() +
            ", and"+ detailedServerStatus.getServerManager().getCurrentMemory();  }

}
