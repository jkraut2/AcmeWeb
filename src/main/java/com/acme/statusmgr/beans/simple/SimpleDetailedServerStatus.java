package com.acme.statusmgr.beans.simple;

import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.StatusInterface;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Service;

/**
 * Abstract base class for all simple detailed Server Status objects.
 * It does not return the the id and content header fields.
 */
public abstract class SimpleDetailedServerStatus implements StatusInterface
{
    StatusInterface detailedServerStatus;

    public SimpleDetailedServerStatus(StatusInterface baseServerStatus) { detailedServerStatus = baseServerStatus; }

    public void setStatusDesc(String statusDesc){detailedServerStatus.setStatusDesc(statusDesc);}

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public long getId() { return 0; }

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public String getContentHeader() {
        return null;
    }

    abstract public String generateStatusDesc();

    public String getStatusDesc(){return detailedServerStatus.getStatusDesc();}

    @Override
    public ServerManager getServerManager() { return detailedServerStatus.getServerManager(); }
}
