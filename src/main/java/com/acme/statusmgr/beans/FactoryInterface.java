package com.acme.statusmgr.beans;

    /**
     * Interface for all Status factories
     * for creating regular and detailed server status
     * objects
     */
    public interface FactoryInterface
    {
        StatusInterface getServerStatus(long id, String contentHeader);
        StatusInterface getExtensionDetailedServerStatus(StatusInterface serverStatus);
        StatusInterface getMemoryDetailedServerStatus(StatusInterface serverStatus);
        StatusInterface getOperationsDetailedServerStatus(StatusInterface serverStatus);
    }

