package agent.disk;

import lombok.Data;
import java.util.ArrayList;

@Data
public class PartitionResponse {
    private ArrayList<Partition> partitions;
    private String hostName;

    public PartitionResponse() {
    }
}