package com.acme.servermgr;

import org.springframework.stereotype.Service;

/**
 * Implement a fake server monitor such as would be used for unit tests, annotated as a Spring Service.
 */
@Service
public class FakeMonitor implements IMonitorableServer {
    @Override
    public String determineServerStatus() {
        return "Server is up";
    }
    @Override
    public String determineCurrentOperations() {
        return " is operating normally";
    }

    @Override
    public String determineCurrentExtension() {
        return " is using these extensions - [Hypervisor, Kubernetes, RAID-6]";
    }

    @Override
    public String determineCurrentMemory() {
        return " its memory is Running low";
    }

    @Override
    public boolean isOperatingNormally() {
        return true;
    }
}