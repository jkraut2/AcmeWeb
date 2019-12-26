package com.acme.statusmgr.Command;

import com.acme.statusmgr.InvalidNameException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;

public class DiskStatusCommandNameVerifierDecorator extends DiskStatusCommandDecorator{

    /**
     * A DiskStatusCommand Decorator that verifies and records who is requesting the disk status. If
     * a name is not listed than request is denied.
     */
        private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

        public DiskStatusCommandNameVerifierDecorator(IDiskStatusCommand baseDiskStatusCommand, String name)
        {
            super(baseDiskStatusCommand);
            if(name == null || name.equals("Anonymous"))
                throw new InvalidNameException();
            else{
                LOGGER.info("User "+name+" was allowed to access disk status information ");
            }


        }

}
