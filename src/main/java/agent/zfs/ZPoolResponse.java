package agent.zfs;

import java.util.ArrayList;

public class ZPoolResponse {

    private ArrayList<ZPool> pool;
    private String hostName;

    public ZPoolResponse()
    {

    }

    public ArrayList<ZPool> getPool() {
        return pool;
    }

    public void setPool(ArrayList<ZPool> pool) {
        this.pool = pool;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
}
