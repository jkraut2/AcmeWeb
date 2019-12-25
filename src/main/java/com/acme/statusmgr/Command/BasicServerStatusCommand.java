package com.acme.statusmgr.Command;
import com.acme.statusmgr.beans.complex.ServerStatus;

/**
 *  A basic command to return the
 *  server status.
 */
public class BasicServerStatusCommand implements ICommand {

    private ServerStatus result;
    private long id;
    private String template;
    private String name;

    public BasicServerStatusCommand(long id, String template, String name)
    {
        this.id = id;
        this.template = template;
        this.name = name;
    }

    @Override
    public void execute()
    {
        result = new ServerStatus(id, String.format(template, name));
        result.setStatusDesc(result.generateStatusDesc());
    }

    public ServerStatus getResult(){return result;}
}
