package agent.disk;

import java.util.ArrayList;

public class ZPoolResponse {

    private ArrayList<ZPool> pool;
    private String hostName;

    public ZPoolResponse()
    {

    }


    public ArrayList<ZPool> getPartitions() {
        return pool;
    }

    public void setPartitions(ArrayList<ZPool> partitions) {
        this.pool = partitions;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
}
