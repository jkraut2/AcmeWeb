package statusmgr;

import com.acme.statusmgr.beans.DiskStatus;
import com.acme.statusmgr.Command.*;
import com.acme.statusmgr.beans.StatusInterface;
import com.acme.statusmgr.beans.complex.ComplexFactory;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class CommandTests
{
    @Test
    public void basicServerStatusCommandTest()
    {

        BasicServerStatusCommand cmd = new BasicServerStatusCommand(1, "Server Status requested by ", "Noach");
        SimpleExecutor executor = new SimpleExecutor(cmd);

        executor.executeCommand();
        StatusInterface result = cmd.getResult();
        assertEquals("Server is up", result.getStatusDesc());
        assertEquals(1, result.getId());
    }

    @Test
    public void detailedServerStatusCommandTest()
    {
        //in place of user providing details
        ArrayList<String> details = new ArrayList<>();
        details.add("memory");
        details.add("extensions");
        DetailedServerStatusCommand cmd = new DetailedServerStatusCommand(1, "Server Status requested by ",
                "Noach", details, "complex", new ComplexFactory());
        SimpleExecutor executor = new SimpleExecutor(cmd);


        executor.executeCommand();
        StatusInterface result = cmd.getResult();
        assertEquals("Server is up, and its memory is Running low, and is using these extensions - [Hypervisor, Kubernetes, RAID-6]", result.getStatusDesc());
        assertEquals(1, result.getId());
    }

    @Test
    public void diskStatusCommandTest()
    {
        DiskStatusCommand cmd = new DiskStatusCommand(1, "Disk Status requested by ", "Noach");
        SimpleExecutor executor = new SimpleExecutor(cmd);


        executor.executeCommand();
        DiskStatus result = cmd.getResult();
        assertEquals("du -c -d1  /", result.getDiskCommand());
        assertEquals(1, result.getId());
    }
}