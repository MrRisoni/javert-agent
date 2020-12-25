package agent.system;

import agent.rest.AgentResponse;
import lombok.Data;

import java.util.ArrayList;

@Data
public class SysProcResponse extends AgentResponse {

    private ArrayList<SysProc> sysproclist;

    public SysProcResponse() {
    }
}