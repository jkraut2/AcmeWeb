package com.acme.statusmgr;

import java.util.concurrent.atomic.AtomicLong;


import com.acme.statusmgr.beans.complex.ServerStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.acme.statusmgr.beans.*;
import com.acme.statusmgr.Command.*;



/**
 * Controller for all web/REST requests about the status of servers
 *
 * For initial school project - just handles info about this server
 * Syntax for URLS:
 *    All start with /server
 *    /status  will give back status of server
 *    a param of 'name' specifies a requester name to appear in response
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


    @Autowired
    private FactoryInterface serverStatusFactory;

    protected static final String template = "Server Status requested by %s";
    protected final AtomicLong counter = new AtomicLong();


    @RequestMapping("/status")
    public ServerStatus statusRequest(@RequestParam(value="name", defaultValue="Anonymous") String name, @RequestParam(value="details", required = false)List <String> details ) {
        System.out.println("*** DEBUG INFO ***" + details);

        BasicServerStatusCommand command = new BasicServerStatusCommand(counter.incrementAndGet(), template, name);
        SimpleExecutor executor = new SimpleExecutor(command);
        executor.executeCommand();
        return command.getResult();

    }
    /**
     *
     * @param name requester
     * @param details requested details
     * @return status of requested details
     */
    @RequestMapping(value = "/status/detailed")
    public StatusInterface getDetailedServiceStatus(@RequestParam(value="name", defaultValue="Anonymous") String name, @RequestParam (required = true) List<String> details, @RequestParam (required = false) String levelofdetail)
    {
        DetailedServerStatusCommand command = new DetailedServerStatusCommand(counter.incrementAndGet(), template, name, details, levelofdetail, serverStatusFactory);
        SimpleExecutor executor = new SimpleExecutor(command);
        executor.executeCommand();
        return command.getResult();

        }

    @RequestMapping("/disk/status")
    public DiskStatus getDiskStatus(@RequestParam(value = "name", defaultValue = "Anonymous") String name) {
        long id = counter.incrementAndGet();
        IDiskStatusCommand command = new DiskStatusCommandNameVerifierDecorator(new DiskStatusCommandQuickReturnDecorator(new DiskStatusCommandConcurrencyDecorator(
                new DiskStatusCommand(id, template, name))), name);
        SimpleExecutor executor = new SimpleExecutor(command);
        executor.executeCommand();
        return command.getResult();
    }

    }

