
package com.acme.servermgr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Manage all servers (service providers) being tracked by the Acme server tracking system
 * For now just some simple methods for use in school project
 */
@Component
public class ServerManager {

    /**
     * Reference to a class that knows how to get details about what we are interested in on a server
     */
    @Autowired
    private IMonitorableServer monitor;

    /**
     * Get the status of this server
     * @return a descriptive string about the servers status
     */
    public String getCurrentServerStatus() {

        String status = monitor.determineServerStatus();

        return status;
    }

    /**
     * Get the current operating status of this server
     * @return a descriptive string about the servers operating status
     */

     public String getCurrentOperations(){ return monitor.determineCurrentOperations();}


    /**
     * Get the extensions this server is currently using
     * @return a descriptive string about the current extensions
     */
     public String  getCurrentExtension()

    {return  monitor.determineCurrentExtension();}


    /**
     * Get the current memory status of this server
     * @return a descriptive string about the servers memory status
     */

    public String getCurrentMemory(){return monitor.determineCurrentMemory();}


    /**
     * Find out if this server is operating normally
     * @return Boolean indicating if server is operating normally
     */
     public Boolean isOperatingNormally()
    {
        return monitor.isOperatingNormally();

    }

}
