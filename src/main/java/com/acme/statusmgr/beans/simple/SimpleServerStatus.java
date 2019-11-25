package com.acme.statusmgr.beans.simple;

import com.acme.statusmgr.Application;
import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.StatusInterface;
import com.fasterxml.jackson.annotation.JsonInclude;

public class SimpleServerStatus implements StatusInterface {

    private  long id;
    private String contentHeader;
    private String statusDesc = "Unknown";

    /**
     * This class now uses an instance of ServerManager
     */
    private ServerManager serverManager;

    /**
     * Construct a ServerStatus using info passed in for identification, and obtaining current
     * server status from the appropriate Manager class.
     *
     * @param id                a numeric identifier/counter of which request this
     * @param contentHeader     info about the request
     */
    public SimpleServerStatus(long id, String contentHeader) {
        this.id = id;
        this.contentHeader = contentHeader;

        // Obtain and save reference to the instance of ServerManager
        serverManager = (ServerManager) Application.getApplicationContext().getBean("serverManager");
    }

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public long getId() {
        return 0;
    }

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public String getContentHeader() { return null; }

    public String getStatusDesc() { return serverManager.getCurrentServerStatus(); }

    public ServerManager getServerManager(){return serverManager;}

}
