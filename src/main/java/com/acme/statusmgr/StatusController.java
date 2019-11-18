package com.acme.statusmgr;


import java.util.concurrent.atomic.AtomicLong;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import statusmgr.beans.*;

/**
 * Controller for all web/REST requests about the status of servers
 *
 * For initial school project - just handles info about this server
 * Syntax for URLS:
 *    All start with /server
 *    /status  will give back status of server
 *    a param of 'name' specifies a requestor name to appear in response
 *
 * Examples:
 *    http://localhost:8080/server/status
 *
 *    http://localhost:8080/server/status?name=Noach
 *
 *
 *
 */

@RestController
@RequestMapping("/server")
public class StatusController {

    protected static final String template = "Server Status requested by %s";
    protected final AtomicLong counter = new AtomicLong();


    @RequestMapping("/status")
    public ServerStatus statusRequest(@RequestParam(value="name", defaultValue="Anonymous") String name, @RequestParam(value="details", required = false)List <String> values ) {
        for (int i = 0; i < values.size(); i++)
        {System.out.println("*** DEBUG INFO ***" + values );}

        return new ServerStatus(counter.incrementAndGet(),
                            String.format(template, name));
    }

    /**
     *
     * @param name requester
     * @param details requested details
     * @return status of requested details
     */
    @RequestMapping(value = "/status/detailed")
    public DetailedServerStatus getDetailedServiceStatus(@RequestParam(value="name", defaultValue="Anonymous") String name, @RequestParam (required = true) List<String> details)
    {
        ServerStatus status = new ServerStatus(counter.incrementAndGet(), String.format(template, name));

        for (String detail : details)
        {
            switch(detail){
                case "operations":
                    OperationsDetailedServerStatus ods = new OperationsDetailedServerStatus(status);
                    return ods;
                case "extensions":
                    ExtensionDetailedServerStatus eds = new ExtensionDetailedServerStatus(status);
                    return eds;
                case "memory":
                    MemoryDetailedServerStatus mds = new MemoryDetailedServerStatus(status);
                    return mds;
                default:
                {
                    throw new InvalidDetailException();
                }
            }



        }
            return null;
        }

    }

