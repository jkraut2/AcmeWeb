package com.acme.statusmgr.beans.simple;
import com.acme.statusmgr.beans.StatusInterface;

public class SimpleOperationsDetailedServerStatus extends SimpleDetailedServerStatus {

    public SimpleOperationsDetailedServerStatus(StatusInterface baseServerStatus)
    { super(baseServerStatus); }

    /**
     * Overrides the base server status getStatusDesc to add
     * on the extensions detail
     * @return a String representing the server status with operations detail
     */
    @Override
    public String generateStatusDesc() { return detailedServerStatus.getStatusDesc() +
            ", and" + detailedServerStatus.getServerManager().getCurrentOperations(); }
}
