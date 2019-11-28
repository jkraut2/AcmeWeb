package com.acme.statusmgr.beans.simple;

import com.acme.statusmgr.beans.StatusInterface;

public class SimpleExtensionDetailedServerStatus extends SimpleDetailedServerStatus {

    public SimpleExtensionDetailedServerStatus(StatusInterface baseServerStatus)
    { super(baseServerStatus); }

    /**
     * Overrides the base server status getStatusDesc to add
     * on the extensions detail
     * @return a String representing the server status with extensions detail
     */
    @Override
    public String getStatusDesc() { return detailedServerStatus.getStatusDesc() + ", and" + detailedServerStatus.getServerManager().getCurrentExtension(); }
}
