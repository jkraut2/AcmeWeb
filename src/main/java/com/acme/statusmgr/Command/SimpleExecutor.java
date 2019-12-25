package com.acme.statusmgr.Command;

     /**
     * Simple executor that executes commands implementing
     * the ICommand Interface
     */
    public class SimpleExecutor
    {
        ICommand command;

        public SimpleExecutor(ICommand command){this.command = command;}

        public void executeCommand(){command.execute();}
    }
