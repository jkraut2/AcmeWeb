package com.acme.statusmgr.Command;
import com.acme.statusmgr.beans.DiskStatus;

    /**
     *  A basic command to return the
     *  disk status.
     */
    public class DiskStatusCommand implements IDiskStatusCommand
    {
        private DiskStatus result;


        public DiskStatusCommand(long id, String template, String name)
        {
            result = new DiskStatus(id, String.format(template, name));
        }

        @Override
        public void execute()
        {

            result.setDiskCommandOutput(result.generateDiskCommandOutput());
            result.setTimeExecuted(System.currentTimeMillis());
        }

        @Override
        public DiskStatus getResult(){return result;}
    }

