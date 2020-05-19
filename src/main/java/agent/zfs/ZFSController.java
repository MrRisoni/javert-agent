package agent.zfs;

import agent.disk.PartitionResponse;
import agent.utils.FileSystemInfo;
import agent.utils.Utilities;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZFSController {

    @GetMapping("/zpool")
    public ZPoolResponse ZFSPool() {
        try {
            ZPoolResponse presp = new ZPoolResponse();
            presp.setHostName(Utilities.getHostName());
            presp.setPool(FileSystemInfo.getZpoolStatus());
            return presp;
        } catch (Exception e) {
            System.out.println("Error");
          System.out.println(e.getMessage());
            return null;

        }
    }


    @GetMapping("/zfslist")
    public PartitionResponse ZFSList() {
        try {
            PartitionResponse presp = new PartitionResponse();
            presp.setHostName(Utilities.getHostName());
            presp.setPartitions(FileSystemInfo.getZFSList());
            return presp;
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
            return null;

        }
    }

}
