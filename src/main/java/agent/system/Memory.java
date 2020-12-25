package agent.system;

import lombok.Data;

@Data
public class Memory {
    private String name;
    private int Total;
    private int Used;

    public Memory() {
    }
}