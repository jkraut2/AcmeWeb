

package com.acme.statusmgr.beans.complex;

import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.StatusInterface;


/**
 * Abstract class representing all types of detailed server status objects used to decorate server status objects.
 */

public abstract class DetailedServerStatus implements StatusInterface
{
    StatusInterface detailedServerStatus;

    public DetailedServerStatus(StatusInterface baseServerStatus) { detailedServerStatus = baseServerStatus; }
    
    public long getId() { return detailedServerStatus.getId(); }

    public String getContentHeader() {
        return detailedServerStatus.getContentHeader();
    }

    abstract public String getStatusDesc();

    @Override
    public ServerManager getServerManager() { return detailedServerStatus.getServerManager(); }

}
