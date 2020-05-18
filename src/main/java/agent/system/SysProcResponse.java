package agent.system;

import agent.rest.AgentResponse;

import java.util.ArrayList;

public class SysProcResponse extends AgentResponse {

    private ArrayList<SysProc> sysproclist;

    public SysProcResponse() {
    }

    public ArrayList<SysProc> getSysproclist() {
        return sysproclist;
    }

    public void setSysproclist(ArrayList<SysProc> sysproclist) {
        this.sysproclist = sysproclist;
    }
}
