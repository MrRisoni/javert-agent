package agent.rest;

import java.text.SimpleDateFormat;
import java.util.Date;


import agent.system.Kernel;
import agent.utils.FileSystemInfo;
import agent.utils.SystemInfo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Skedul {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  /*  @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println(dateFormat.format(new Date()));
    }


    @Scheduled(fixedRate = 5000)
    public void anotherRerouse() {
        Kernel kern = SystemInfo.kernelData();
        System.out.println(kern);
    } */

    @Scheduled(fixedRate = 5000)
    public void zfsData() {
        System.out.println(FileSystemInfo.getZFSList().get(0));
    }
}
