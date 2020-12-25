package agent.system;

import lombok.Data;

@Data
public class SysProc {
    // ps aux
    private String user;
    private int pid;
    private String cpu;
    private String mem;
    private String command;

    public SysProc() {
    }
}