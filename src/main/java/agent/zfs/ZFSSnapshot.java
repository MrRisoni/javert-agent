package agent.zfs;

import lombok.Data;

@Data
public class ZFSSnapshot {

    private String name;
    private String used;

    public ZFSSnapshot() {
    }
}