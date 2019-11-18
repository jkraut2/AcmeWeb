<<<<<<< Updated upstream:src/main/java/statusmgr/beans/ServerStatus.java
package statusmgr.beans;

import servermgr.ServerManager;
=======
package com.acme.statusmgr.beans;
import com.acme.Application;
import com.acme.servermgr.ServerManager;
>>>>>>> Stashed changes:src/main/java/com/acme/statusmgr/beans/ServerStatus.java

/**
 * A POJO that represents Server Status and can be used to generate JSON for that status
 */
public class ServerStatus {

    protected long id;
    protected String contentHeader;
    protected String statusDesc = "Unknown";

    /**
     * This will refer to an instance of the ServerManager class (no longer static)
     */
    private ServerManager serverManager;


    /**
     * Construct a ServerStatus using info passed in for identification, and obtaining current
     * server status from the appropriate Manager class.
     *
     * @param id                a numeric identifier/counter of which request this
     * @param contentHeader     info about the request
     */
    public ServerStatus(long id, String contentHeader) {
        this.id = id;
        this.contentHeader = contentHeader;

        // Obtain current status of server
        this.statusDesc = ServerManager.getCurrentServerStatus();

        // Obtain and save reference to the ServerManager
        serverManager = (ServerManager) Application.getApplicationContext().getBean("serverManager");
    }

    public ServerStatus() {

    }

    public long getId() {
        return id;
    }

    public String getContentHeader() {

        return contentHeader;
    }


    public String getStatusDesc() {
        return serverManager.getCurrentServerStatus();
    }


}
