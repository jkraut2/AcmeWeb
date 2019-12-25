

package com.acme.statusmgr.beans.complex;
import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.StatusInterface;
import com.acme.statusmgr.beans.complex.DetailedServerStatus;


/**
 * Decorator class for server status objects where extension status has been requested.
 */

public class ExtensionDetailedServerStatus extends DetailedServerStatus {



    public ExtensionDetailedServerStatus(StatusInterface sStatus) {
        super(sStatus);
    }

    /**
     * Overrides the base server status's getStatusDesc to add
     * on to it the extensions detail
     *
     * @return a String representing the server status with extensions detail
     */
    @Override
    public String generateStatusDesc() {
        return detailedServerStatus.generateStatusDesc() + ", and" +
                detailedServerStatus.getServerManager().getCurrentExtension();
    }

}


