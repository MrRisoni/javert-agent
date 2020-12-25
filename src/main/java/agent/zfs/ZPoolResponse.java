package agent.zfs;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ZPoolResponse {

    private ArrayList<ZPool> pool;
    private String hostName;

    public ZPoolResponse() {
    }
}