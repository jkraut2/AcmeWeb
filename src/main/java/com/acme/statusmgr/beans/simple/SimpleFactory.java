package com.acme.statusmgr.beans.simple;

import com.acme.statusmgr.beans.FactoryInterface;
import com.acme.statusmgr.beans.StatusInterface;
import org.springframework.stereotype.Service;

/**
 * Factory for creating simple server status objects
 * and simple detailed server status objects
 * Annotation @Service for Swing Injection
 */
public class SimpleFactory implements FactoryInterface {

    @Override
    public StatusInterface getServerStatus(long id, String contentHeader) {
        return new SimpleServerStatus(id, contentHeader);
    }

    @Override
    public SimpleDetailedServerStatus getExtensionDetailedServerStatus(StatusInterface serverStatus) {
        return new SimpleExtensionDetailedServerStatus(serverStatus);
    }

    @Override
    public SimpleDetailedServerStatus getMemoryDetailedServerStatus(StatusInterface serverStatus) {
        return new SimpleMemoryDetailedServerStatus(serverStatus);
    }

    @Override
    public SimpleDetailedServerStatus getOperationsDetailedServerStatus(StatusInterface serverStatus) {
        return new SimpleOperationsDetailedServerStatus(serverStatus);
    }
}
