package agent.zfs;

import lombok.Data;

@Data
public class ZPool {

    private String disk;
    private  String State;

    public ZPool(String disk, String state) {
        this.disk = disk;
        this.State = state;
    }
}