package com.acme.statusmgr.Command;
import com.acme.statusmgr.beans.DiskStatus;

public abstract class DiskStatusCommandDecorator implements IDiskStatusCommand
{
    IDiskStatusCommand baseDiskStatusCommand;

    public DiskStatusCommandDecorator(IDiskStatusCommand baseDiskStatusCommand){this.baseDiskStatusCommand = baseDiskStatusCommand;}

    @Override
    public DiskStatus getResult() { return baseDiskStatusCommand.getResult(); }

    @Override
    public void execute() { baseDiskStatusCommand.execute(); }
}
