

package com.acme.statusmgr.beans.complex;
import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.StatusInterface;
import com.acme.statusmgr.beans.complex.DetailedServerStatus;


/**
 * Decorator class for server status objects where extension status has been requested.
 */

public class ExtensionDetailedServerStatus extends DetailedServerStatus {


    protected long id;
    protected String contentHeader;
    protected String statusDesc = "Unknown";


    public ExtensionDetailedServerStatus(StatusInterface sStatus) {
        super(sStatus);
    }
    /**
     *
     * @return a string containing the server and extension status description
     */
    public String getStatusDesc(){
      
        return detailedServerStatus.getStatusDesc() + ",and" +
        detailedServerStatus.getServerManager(); }
    }


