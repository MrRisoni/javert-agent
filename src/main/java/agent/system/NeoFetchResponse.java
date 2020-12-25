package agent.system;

import agent.rest.AgentResponse;
import lombok.Data;

@Data
public class NeoFetchResponse extends AgentResponse {
    private String kernel;
    private String os;
    private String uptime;
    private String cpu;
    private String memory;
    private String cpuUsage;
    private String diskUsage;

    public NeoFetchResponse() {
    }
}
