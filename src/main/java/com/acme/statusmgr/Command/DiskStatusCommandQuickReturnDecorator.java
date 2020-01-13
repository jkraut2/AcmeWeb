package com.acme.statusmgr.Command;
import com.acme.statusmgr.DiskStatusUnavailableException;
import com.acme.statusmgr.beans.DiskStatus;
import com.acme.statusmgr.Command.IDiskStatusCommand;


/*
A disk command decorator that returns quick results by returning old information which
it has stored provided that the information is with in the last 60 seconds. If it is not than a new command is
started.
 */
public class DiskStatusCommandQuickReturnDecorator extends DiskStatusCommandDecorator {

    private static DiskStatus recentDiskStatus;


    public DiskStatusCommandQuickReturnDecorator(IDiskStatusCommand baseDiskStatusCommand)
    {
        super(baseDiskStatusCommand);

    }

    @Override
    public void execute()
    {
        if(recentDiskStatus != null && System.currentTimeMillis() - recentDiskStatus.getTimeExecuted() < 60_000)
            super.getResult().setDiskCommandOutput(recentDiskStatus.getDiskCommandOutput());
        else
        {
            Thread diskStatusHandlerThread = new Thread(new DiskStatusHandlerThread());
            diskStatusHandlerThread.start();
            throw new DiskStatusUnavailableException();
        }
    }


    /**
     * Private inner class that calls execute
     * on the base DiskStatus Command Object.
     * Implements runnable and is meant to be
     * run on a different thread. In order to get new server status
     * while error can be displayed immediately.
     */
    private class DiskStatusHandlerThread implements Runnable
    {
        @Override
        public void run()
        {
            baseDiskStatusCommand.execute();
            recentDiskStatus = baseDiskStatusCommand.getResult();
        }
    }
}
