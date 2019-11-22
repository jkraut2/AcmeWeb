

package com.acme.statusmgr.beans;
import com.acme.servermgr.ServerManager;



/**
 * Decorator class for server status objects where extension status has been requested.
 */

public class ExtensionDetailedServerStatus implements StatusInterface {


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
      
        return ServerManager.getCurrentServerStatus() + ",and" +
                ServerManager.getCurrentExtension();
    }

}
