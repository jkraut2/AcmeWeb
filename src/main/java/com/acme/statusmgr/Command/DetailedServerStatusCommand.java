package com.acme.statusmgr.Command;

import com.acme.statusmgr.*;
import com.acme.statusmgr.beans.FactoryInterface;
import com.acme.statusmgr.beans.StatusInterface;
import com.acme.statusmgr.beans.simple.SimpleFactory;

import java.util.List;

/**
 *  A detailed command to return the
 *  server status.
 */
public class DetailedServerStatusCommand implements ICommand {

    private StatusInterface status;
    private long id;
    private String template;
    private String name;
    private List<String> details;
    private String levelOfDetail;
    private FactoryInterface serverStatusFactory;

    public DetailedServerStatusCommand(long id, String template, String name, List<String> details, String levelofdetail, FactoryInterface serverStatusFactory)
    {
        this.id = id;
        this.template = template;
        this.name = name;
        this.details = details;
        this.levelOfDetail = levelofdetail;
        this.serverStatusFactory = serverStatusFactory;
    }

    //put factory into the execute of command, as described in lecture.
    @Override
    public void execute()
    {
        if(levelOfDetail != null)
        {
            if(levelOfDetail.equals("simple"))
                serverStatusFactory = new SimpleFactory();
            else if(!levelOfDetail.equals("complex"))
                throw new InvalidLevelOfDetailException();
        }

        status = serverStatusFactory.getServerStatus(id, String.format(template, name));

        for (String detail : details)
        {
            switch (detail)
            {
                case "operations":
                {
                    status = serverStatusFactory.getOperationsDetailedServerStatus(status);
                    break;
                }
                case "extensions":
                {
                    status = serverStatusFactory.getExtensionDetailedServerStatus(status);
                    break;
                }
                case "memory":
                {
                    status = serverStatusFactory.getMemoryDetailedServerStatus(status);
                    break;
                }
                default:
                {
                    throw new InvalidDetailException();
                }
            }
        }
        status.setStatusDesc(status.generateStatusDesc());
    }

    public StatusInterface getResult(){return status;}
}
