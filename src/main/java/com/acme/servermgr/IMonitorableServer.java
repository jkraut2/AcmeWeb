package com.acme.servermgr;

/**
 * Declare contract for what a server monitor must be capable of doing.
 */
public interface IMonitorableServer {

    /**
     * A way to get a general description of the server's status.
     * @return A String with various basic info about server.
     */
    String determineServerStatus();

    /**
     * @return A String representing current operations the server is running
     */
    String determineCurrentOperations();

    /**
     * @return A String representing current extensions the server is running
     */
    String determineCurrentExtension();

    /**
     * @return A String representing the server's current memory
     */
    String determineCurrentMemory();
    /*
        @return A boolean representing the that the server is operating memory
     */
    boolean isOperatingNormally();

}