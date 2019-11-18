package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;

/**
 * Abstract class representing all types of detailed server status objects used to decorate server status objects.
 */
public abstract class DetailedServerStatus {

    ServerStatus detailedServerStatus;

    public DetailedServerStatus(ServerStatus serverStatus) { detailedServerStatus = serverStatus; }

    public long getId() { return detailedServerStatus.getId(); }

    public String getContentHeader() {
        return detailedServerStatus.getContentHeader();
    }

    abstract public String getStatusDesc();

}
