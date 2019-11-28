package com.acme.statusmgr.beans.complex;


import com.acme.statusmgr.beans.*;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Factory for creating regular and detailed complex server status objects.
 * Autowiring makes this class the default for serverStatus factories
 */
@Service
@Primary
public class ComplexFactory implements FactoryInterface
{
    @Override
    public StatusInterface getServerStatus(long id, String contentHeader) {
        return new ServerStatus(id, contentHeader);
    }

    @Override
    public DetailedServerStatus getExtensionDetailedServerStatus(StatusInterface serverStatus) {
        return new ExtensionDetailedServerStatus(serverStatus);
    }

    @Override
    public DetailedServerStatus getMemoryDetailedServerStatus(StatusInterface serverStatus) {
        return new MemoryDetailedServerStatus(serverStatus);
    }

    @Override
    public DetailedServerStatus getOperationsDetailedServerStatus(StatusInterface serverStatus) {
        return new OperationsDetailedServerStatus(serverStatus);
    }
}
