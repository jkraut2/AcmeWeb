
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

    static public String getCurrentOperations(){ return " and is operating normally";}


    /**
     * Get the extensions this server is currently using
     * @return a descriptive string about the current extensions
     */
    static public String  getCurrentExtension()

    {return  " and is using these extensions : [Hypervisor, Kubernetes, RAID-6]";}


    /**
     * Get the current memory status of this server
     * @return a descriptive string about the servers memory status
     */

    static public String getCurrentMemory(){return " and the memory is low";}


    /**
     * Find out if this server is operating normally
     * @return Boolean indicating if server is operating normally
     */
    static public Boolean isOperatingNormally()
    {
        return true;

    } //TODO should eventually use the monitor interface

}
