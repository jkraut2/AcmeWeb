package com.acme.statusmgr.Command;
import com.acme.statusmgr.beans.DiskStatus;

    /**
     *  A basic command to return the
     *  disk status.
     */
    public class DiskStatusCommand implements IDiskStatusCommand
    {
        private DiskStatus result;
        private long id;
        private String template;
        private String name;

        /**
         *
         * @param id - command id number
         * @param template - way the command should look
         * @param name - name of requester
         */
        public DiskStatusCommand(long id, String template, String name)
        {
            this.id = id;
            this.template = template;
            this.name = name;
        }

        @Override
        public void execute()
        {
            result = new DiskStatus(id, String.format(template, name));
            result.setDiskCommandOutput(result.generateDiskCommandOutput());
            result.setTimeExecuted(System.currentTimeMillis());
        }

        @Override
        public DiskStatus getResult(){return result;}
    }

