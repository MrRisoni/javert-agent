package agent.disk;

import java.util.ArrayList;

public class PartitionResponse {

    private ArrayList<Partition> partitions;
    private String hostName;

    public PartitionResponse()
    {

    }


    public ArrayList<Partition> getPartitions() {
        return partitions;
    }

    public void setPartitions(ArrayList<Partition> partitions) {
        this.partitions = partitions;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
}
