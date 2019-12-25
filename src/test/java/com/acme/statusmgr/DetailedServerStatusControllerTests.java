
package com.acme.statusmgr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test for the ten test cases.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DetailedServerStatusControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void noParamDetailsError() throws Exception
    {
        this.mockMvc.perform(get("/server/status/detailed")).andExpect(status().is4xxClientError()).andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void namelessParamDetailsOperationsRequest() throws Exception
    {
        this.mockMvc.perform(get("/server/status/detailed")
                .param("details", "operations"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Anonymous")).
                andExpect(jsonPath("$.statusDesc").value("Server is up,and is operating normally"));
    }

    @Test
    public void namelessParamOperationsAndExtensionsDetailsRequest() throws Exception
    {
        this.mockMvc.perform(get("/server/status/detailed")
                .param("details", "operations,extensions"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Anonymous")).
                andExpect(jsonPath("$.statusDesc").value("Server is up,and is operating normally"+
                        ",and is using these extensions - [Hypervisor, Kubernetes, RAID-6]"));
    }

    @Test
    public void namelessParamOperationsExtensionsMemoryDetailsRequest() throws Exception
    {
        this.mockMvc.perform(get("/server/status/detailed")
                .param("details", "operations,extensions,memory"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Anonymous")).
                andExpect(jsonPath("$.statusDesc").value("Server is up,and is operating normally,and is "+
                        "using these extensions - [Hypervisor, Kubernetes, RAID-6],and its memory is Running low"));
    }

    @Test
    public void paramOperationsExtensionsMemoryDetailsRequestWithName() throws Exception
    {
        this.mockMvc.perform(get("/server/status/detailed")
                .param("details", "operations,extensions,memory")
                .param("name", "Zev")) // my name
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Zev")).
                andExpect(jsonPath("$.statusDesc").value("Server is up,and is operating normally" +
                        ",and is using these extensions - [Hypervisor, Kubernetes, RAID-6],and its memory is Running low"));
    }

    @Test
    public void paramOperationsAndMemoryDetailsRequestWithName() throws Exception
    {
        this.mockMvc.perform(get("/server/status/detailed")
                .param("name", "Zev")
                .param("details", "operations,memory"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Zev")).
                andExpect(jsonPath("$.statusDesc").value("Server is up,and is operating normally"
                        +",and its memory is Running low"));
    }

    @Test
    public void paramExtensionsAndMemoryDetailsRequestWithName() throws Exception
    {
        this.mockMvc.perform(get("/server/status/detailed?details=extensions,memory&name=Noach"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Noach")).
                andExpect(jsonPath("$.statusDesc").value("Server is up,and is using these extensions "+
                        "- [Hypervisor, Kubernetes, RAID-6],and its memory is Running low"));
    }

    @Test
    public void paramNameAndExtensionsAndMemoryDetailsRequest() throws Exception
    {
        this.mockMvc.perform(get("/server/status/detailed?name=Noach&details=extensions,memory"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Noach")).
                andExpect(jsonPath("$.statusDesc").value("Server is up,and is using these extensions" +
                        " - [Hypervisor, Kubernetes, RAID-6],and its memory is Running low"));
    }

    @Test
    public void paramOperationsMemoryExtensionsMemoryRepeat() throws Exception
    {
        this.mockMvc.perform(get("/server/status/detailed")
                .param("details", "memory,operations,extensions,memory"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Anonymous")).
                andExpect(jsonPath("$.statusDesc").value("Server is up,and its memory is Running low," +
                        "and is operating normally,and is using these extensions - [Hypervisor, " +
                        "Kubernetes, RAID-6],and its memory is Running low"));
    }

    @Test
    public void invalidDetailRequest() throws Exception
    {
        this.mockMvc.perform(get("/server/status/detailed")
                .param("details", "memory,operations,junkERROR")).andExpect(status().is4xxClientError());
    }

}
