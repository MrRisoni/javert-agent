package agent.system;

import lombok.Data;

@Data
public class Kernel {
    private String version;
    private String created;

    public Kernel() {
    }
}