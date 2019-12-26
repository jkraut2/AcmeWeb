package com.acme.statusmgr.Command;


import com.acme.statusmgr.Command.ICommand;
import com.acme.statusmgr.beans.DiskStatus;

/**
 * Interface for DiskStatus Commands
 * Used to define what a DiskStatus command does
 * in proxy pattern.
 */
public interface IDiskStatusCommand extends ICommand
{
    DiskStatus getResult();
}
