package com.acme.statusmgr.Command;

import com.acme.diskmgr.DiskManager;
import com.acme.statusmgr.CheckDiskCommandConcurrencyException;

/**
 * DiskStatus decorator that ensures that only one DiskStatus runs at once. If not
 * an exception is thrown.
 */
public class DiskStatusCommandConcurrencyDecorator extends DiskStatusCommandDecorator
{
    public DiskStatusCommandConcurrencyDecorator(IDiskStatusCommand baseDiskStatusCommand)
    { super(baseDiskStatusCommand); }

    @Override
    public void execute()
    {
        if(DiskManager.getInstance().numTestsRunning() > 1)
            throw new CheckDiskCommandConcurrencyException();
        else
            super.execute();
    }
}